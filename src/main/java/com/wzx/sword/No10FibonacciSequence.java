package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author wzx
 */
public class No10FibonacciSequence {

  /**
   * 青蛙跳与斐波那契数组思路一致
   * 当 n>2 时，第一次跳的时候就有两种不同的选择：
   * 一是第一次跳1级，此时跳法数目等于后面剩下的 n-1 级台阶的跳法数目，即为 f(n-1)
   * 二是第一次跳2级，此时跳法数目等于后面剩下的 n-2 级台阶的跳法数目，即为 f(n-2)
   * 因此，n级台阶的不同跳法的总数f(n) = f(n-1) + f(n-2)
   */

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int fib1(int n) {
    if (0 == n) return 0;
    if (1 == n || 2 == n) return 1;

    int n1 = 1;
    int n2 = 1;
    for (int i = 0; i < n - 2; i++) {
      // 题目要求取模
      int sum = (n1 + n2) % 1000000007;
      n1 = n2;
      n2 = sum;
    }
    return n2;
  }

  /**
   * 递归
   * 时间空间复杂度计算 https://blog.csdn.net/lxf_style/article/details/80458519
   * <p>
   * time: O(2^n)
   * space: O(1)
   */
  public int fib2(int n) {
    if (0 == n) return 0;
    if (1 == n || 2 == n) return 1;

    // 题目要求取模
    return (fib2(n - 1) + fib2(n - 2))% 1000000007;
  }
}
