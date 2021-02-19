package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/">https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/</a>
 * @author wzx
 */
public class No1541MinimumInsertionsToBalanceAParenthesesString {

  public int minInsertions(String s) {
    // 需要多少个)才能平衡
    int balance = 0;
    int insert = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {

        if ((balance & 1) == 1) {
          // 如果是奇数说明有个(刚匹配了一半，现在补上一个)
          insert++;
          balance--;
        }
        balance += 2;

      } else if (balance == 0 && ch == ')') {

        if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
          // )) => ())
          insert++;
          i++;
        } else {
          // ) => ())
          insert += 2;
        }

      } else {
        balance--;
      }
    }

    return balance + insert;
  }
}
