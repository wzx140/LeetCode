package com.wzx.leetcode;

import com.wzx.entity.UF;

/**
 * @see <a href="https://leetcode.com/problems/satisfiability-of-equality-equations/">https://leetcode.com/problems/satisfiability-of-equality-equations/</a>
 * @author wzx
 */
public class No990SatisfiabilityOfEqualityEquations {

  /**
   * 并查集
   *
   * time: O(n)
   * space: O(n)
   */
  public boolean equationsPossible(String[] equations) {
    UF uf = new UF(26);
    for (String equation : equations) {
      int x = equation.charAt(0) - 'a';
      int y = equation.charAt(3) - 'a';
      // 加入连通关系
      if (equation.charAt(1) == '=') {
        uf.union(x, y);
      }
    }
    for (String equation : equations) {
      int x = equation.charAt(0) - 'a';
      int y = equation.charAt(3) - 'a';
      // 判断不连通关系
      if (equation.charAt(1) == '!' && uf.isConnect(x, y)) {
        return false;
      }
    }
    return true;
  }
}
