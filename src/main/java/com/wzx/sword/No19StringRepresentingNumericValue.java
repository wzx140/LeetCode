package com.wzx.sword;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2
 *
 * @author wzx
 */
public class No19StringRepresentingNumericValue {

  public static boolean isNumeric1(char[] str) {
    boolean point = false;
    boolean e = false;

    List<Character> validChar = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'e', 'E', '+', '-', '.');
    List<Character> es = Arrays.asList('e', 'E');
    List<Character> signal = Arrays.asList('+', '-');

    for (int i = 0; i < str.length; i++) {
      char ch = str[i];
      // 只有首位能或者e后出现+-
      if ((i != 0) && !es.contains(str[i - 1]) && signal.contains(ch)) return false;

      // 不允许其他字母
      if (!validChar.contains(ch)) return false;

      // 不能重复出现e和.
      if (point && ch == '.') return false;
      if (e && es.contains(ch)) return false;

      // 小数不能作为指数
      if (e && ch == '.') return false;

      // 标记e和.
      if (!point && ch == '.') point = true;
      if (!e && es.contains(ch)) e = true;
    }

    // 不能以e + -结尾
    char tail = str[str.length - 1];

    return !es.contains(tail) && !signal.contains(tail);
  }

  public static boolean isNumeric2(char[] str){
    String pattern = "^[-+]?\\d*(\\.\\d*)?([eE][+-]?\\d+)?$";
    String s = new String(str);
    return Pattern.matches(pattern, s);
  }
}
