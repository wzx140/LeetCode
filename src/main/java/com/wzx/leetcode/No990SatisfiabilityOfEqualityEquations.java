package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * @author wzx
 */
public class No990SatisfiabilityOfEqualityEquations {

  private static class UF {
    private int[] parent = null;
    private int[] count = null;

    public UF(int size) {
      parent = new int[size];
      count = new int[size];
      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }
    }

    /**
     * 寻找根结点
     */
    public int find(int x) {
      if (parent[x] == x) return x;
      // 路径压缩
      parent[x] = find(parent[x]);
      return parent[x];
    }

    /**
     * 连接两个树
     */
    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return;
      }

      // 加权合并
      if (count[rootX] < count[rootY]) {
        int tmp = rootX;
        rootX = rootY;
        rootY = tmp;
      }
      parent[rootY] = rootX;
      count[rootX] += count[rootY];
    }

    public boolean isConnect(int x, int y) {
      return find(x) == find(y);
    }
  }

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
