package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/">https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/</a>
 */
public class No5ReplaceWhiteSpace {

  /**
   * 从右往左，现在尾部添加合适空白元素，双指针再从后往前将元素移动到正确的位置
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public String replaceSpace(String s) {
    int exSize = s.length();
    // 填充字符串
    int size = exSize;
    for (int i = 0; i < exSize; i++) {
      if (s.charAt(i) == ' ') {
        size += 2;
      }
    }
    char[] res = new char[size];

    // 双指针
    int pt = size - 1;
    for (int i = exSize - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (s.charAt(i) == ' ') {
        res[pt--] = '0';
        res[pt--] = '2';
        res[pt--] = '%';
      } else {
        res[pt--] = ch;
      }
    }

    return new String(res);
  }
}
