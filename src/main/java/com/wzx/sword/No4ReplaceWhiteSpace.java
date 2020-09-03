package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 *
 * @author wzx
 */
public class No4ReplaceWhiteSpace {

  /**
   * 从左往右
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public static String replaceSpace1(StringBuffer str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        int length = str.length();
        str.setLength(length + 2);
        // 后移3位
        for (int j = length - 1; j > i; j--) {
          str.setCharAt(j + 2, str.charAt(j));
        }
        str.replace(i, i + 3, "%20");
        i += 2;
      }
    }

    return str.toString();
  }

  /**
   * 从右往左，现在尾部添加合适空白元素，双指针再从后往前将元素移动到正确的位置
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static String replaceSpace2(StringBuffer str) {
    int size = str.length();
    // 填充字符串
    int exSize = size;
    for (int i = 0; i < size; i++) {
      if (str.charAt(i) == ' ') {
        exSize += 2;
      }
    }
    str.setLength(exSize);

    // 双指针
    int cur = size - 1;
    int pt = exSize - 1;
    while (cur >= 0) {
      if (str.charAt(cur) == ' ') {
        str.replace(pt - 2, pt + 1, "%20");
        pt -= 3;
      } else {
        str.setCharAt(pt, str.charAt(cur));
        pt -= 1;
      }
      cur--;
    }

    return str.toString();
  }
}
