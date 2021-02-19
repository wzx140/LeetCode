package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/">https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/</a>
 * @author wzx
 */
public class No62TheLastRemainingNumberInTheCircle {

  /**
   * 约瑟夫环问题，递归倒退
   * 剩下数: 最终返回的数
   * f(n, m): 序列长度为n时，每次删除第m个数，剩下数在当前序列中的序号
   * (m-1)%n: 在f(n, m)中，删除的第一个数在f(n, m)序列中的序号
   * f(n, m)与f(n-1, m)返回的数字值相同，只是在当前场景下的序号不同
   * 所以剩下数在f(n-1, m)中的序号若要转化为在f(n, m)中的序号，可以这样看，f(n-1, m)序列相当于从f(n, m)序列的第m%n位开始
   * 所以得到递推公式: f(n, m) = (f(n-1, m) + m%n)%n = (f(n-1, m) + m)%n
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int lastRemaining1(int n, int m) {
    if (n == 1) return 0;

    return (lastRemaining1(n - 1, m) + m) % n;
  }

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int lastRemaining2(int n, int m) {
    int f = 0;
    for (int i = 2; i <= n; i++) {
      f = (f + m) % i;
    }

    return f;
  }
}
