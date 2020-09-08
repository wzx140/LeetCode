package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
 * <p>
 * 青蛙跳解题思路一致：https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 * 当 n>2 时，第一次跳的时候就有两种不同的选择：
 * 一是第一次跳1级，此时跳法数目等于后面剩下的 n-1 级台阶的跳法数目，即为 f(n-1)
 * 二是第一次跳2级，此时跳法数目等于后面剩下的 n-2 级台阶的跳法数目，即为 f(n-2)
 * 因此，n级台阶的不同跳法的总数f(n) = f(n-1) + f(n-2)
 *
 * @author wzx
 */
public class No9FibonacciSequence {

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static int fibonacci1(int n) {
    if (0 == n) return 0;
    if (1 == n || 2 == n) return 1;

    int n1 = 1;
    int n2 = 1;
    for (int i = 0; i < n - 2; i++) {
      int sum = n1 + n2;
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
  public static int fibonacci2(int n) {
    if (0 == n) return 0;
    if (1 == n || 2 == n) return 1;

    return fibonacci2(n - 1) + fibonacci2(n - 2);
  }
}
