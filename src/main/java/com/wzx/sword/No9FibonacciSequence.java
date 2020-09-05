package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
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
  public static int Fibonacci1(int n) {
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
  public static int Fibonacci2(int n) {
    if (0 == n) return 0;
    if (1 == n || 2 == n) return 1;

    return Fibonacci2(n - 1) + Fibonacci2(n - 2);
  }
}
