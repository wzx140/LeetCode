package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/qiu-12n-lcof/">https://leetcode-cn.com/problems/qiu-12n-lcof/</a>
 * @author wzx
 */
public class No64Solve1ton {

  /**
   * 利用逻辑运算符的短路性质形成递归的出口条件
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int sumNums1(int n) {
    boolean flag = n > 0 && (n += sumNums1(n - 1)) > 0;
    return n;
  }

  /**
   * 快速乘
   * A*B = sum(A << bit_i(B))
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int sumNums2(int n) {
    return recursion(n, n + 1) >> 1;
  }

  private int recursion(int a, int b) {
    int ans = 0;
    boolean flag = b > 0 &&
            // 当b的当前位为0时, a & -(b & 1) = a & 0 = 0
            // 当b的当前位为1时, a & -(b & 1) = a & -1 = a
            (ans = (a & -(b & 1)) +
                    recursion(a << 1, b >> 1)) > 0;
    return ans;
  }
}
