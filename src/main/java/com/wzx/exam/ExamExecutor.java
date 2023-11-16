package com.wzx.exam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExamExecutor {

  private final List<List<String>> questions = new LinkedList<>();
  private final boolean cn;
  private static final Pattern PATTERN = Pattern.compile("@see <a href=\"(.*?)\">");
  private static final List<String> webDomain = Arrays.asList("leetcode", "lintcode", "nowcoder");

  public ExamExecutor(String basePath, boolean cn) throws IOException {
    this.cn = cn;
    this.questions.addAll(getQuestions(Paths.get(basePath, "src/main/java/com/wzx/leetcode")));
    this.questions.addAll(getQuestions(Paths.get(basePath, "src/main/java/com/wzx/sword")));
    Collections.shuffle(questions);
  }

  public ExamExecutor() throws IOException {
    this("", true);
  }

  private List<List<String>> getQuestions(Path sourcePath) throws IOException {
    return Files.list(sourcePath)
        .map(this::parseCodeInSource)
        .filter(l -> !l.isEmpty())
        .collect(Collectors.toList());
  }

  private List<String> parseCodeInSource(Path sourcePath) {
    try {
      String text = String.join("\n", Files.readAllLines(sourcePath));
      Matcher matcher = PATTERN.matcher(text);

      List<String> matches = new LinkedList<>();
      while (matcher.find()) {
        String group = matcher.group(1);
        if (webDomain.stream().anyMatch(domain -> group.toLowerCase().contains(domain))) {
          matches.add(matcher.group(1));
        }
      }
      if (matches.size() != 1) {
        System.err.println("Found invalid question " + sourcePath);
        return Collections.emptyList();
      } else {
        List<String> res = new LinkedList<>();
        res.add(transform(matches.get(0)));
        res.add("file://" + sourcePath.toAbsolutePath().toString());
        return res;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String transform(String webUrl) {
    if (cn) {
      return webUrl.replace("leetcode.com", "leetcode.cn");
    } else {
      return webUrl;
    }
  }

  @Override
  public String toString() {
    return questions.stream()
        .map(question -> question.get(0) + '\n' + question.get(1) + '\n')
        .collect(Collectors.joining("\n"));
  }

  public static void main(String[] args) throws IOException {
    Path tmpPath = Paths.get("tmp");
    if (!Files.exists(tmpPath)) {
      String questions = new ExamExecutor().toString();
      Files.write(tmpPath, questions.getBytes(StandardCharsets.UTF_8));
    }
    Files.readAllLines(tmpPath).forEach(System.out::println);
  }
}
