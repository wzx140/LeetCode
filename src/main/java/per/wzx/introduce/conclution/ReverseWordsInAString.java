package per.wzx.introduce.conclution;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {

    /**
     * the in-place on stringBuilder, reverse all string and reverse each word
     * some variables that hold the index
     * i : the begin index of current word
     * j : the index move from start begin to end of current word
     * storeIndex : the index of store position
     * tempIndex : the index move from start begin to end of store position(in one cycle(word))
     */
    public String reverseWords1(String s) {
        int storeIndex = 0;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {

                // add the space after word
                if (storeIndex != 0) {
                    sb.setCharAt(storeIndex++, ' ');
                }

                // move the word to last store position
                int tempIndex = storeIndex;
                int j = i;
                while (j < sb.length() && sb.charAt(j) != ' ') {
                    sb.setCharAt(tempIndex++, sb.charAt(j++));
                }

                // reverse the word
                String t = (new StringBuilder(sb.substring(storeIndex, tempIndex))).reverse().toString();
                sb.replace(storeIndex, tempIndex, t);

                storeIndex = tempIndex;
                i = j;
            }
        }

        sb.setLength(storeIndex);
        return sb.toString();
    }

//    anti-traverse the string and add word in stringBuilder
    public String reverseWords2(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        // the state of recording the word
        boolean stop = false;
        // the begin index of the word
        int start = s.length() - 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && stop) {
                // start to record the word
                start = i;
                stop = false;
            } else if (s.charAt(i) == ' ' && !stop) {
                // touch the end of the word, restore the word with its index
                sb.append(s, i + 1, start + 1);
                sb.append(' ');
                stop = true;
            }
        }
        sb.append(s, 0, start + 1);

        return sb.toString();
    }

    public String reverseWords3(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
