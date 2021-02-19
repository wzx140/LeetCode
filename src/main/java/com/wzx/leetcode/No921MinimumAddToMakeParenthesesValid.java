package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/">https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/</a>
 * @author wzx
 */
public class No921MinimumAddToMakeParenthesesValid {

  /**
   *
   * time: O(n)
   * space: O(1)
   */
  public int minAddToMakeValid(String S) {
    // 需要多少个)才能平衡
    int balance = 0;
    int insert = 0;

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (ch == '(') {
        balance++;
      } else if (balance == 0 && ch == ')') {
        insert++;
      } else {
        balance--;
      }
    }

    return balance + insert;
  }
}
