package per.wzx.introduce.string;

// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        //  find the Minimum value
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        int length = minLength;

        char[] res = new char[length];
        for (int i = 0; i < length; i++) {
            boolean coincidence = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    coincidence = false;
                }
            }
            if (!coincidence) {
                break;
            }
            res[i] = strs[0].charAt(i);
        }
        return String.valueOf(res).trim();
    }
}
