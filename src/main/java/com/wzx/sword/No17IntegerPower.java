package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 *
 * @author wzx
 */
public class No17IntegerPower {

  /**
   * 快速幂 递归
   * a^n = a^(n/2) * a^(n/2) ; n为偶数
   * a^n = a^((n-1)/2) * a^((n-1)/2) * a ; n为奇数
   * <p>
   * time: O(logn)
   * space: O(logn)
   */
  public static double power1(double base, int exponent) {
    if (base == 0) return 0;

    int signal = base > 0 ? 1 : -1;
    int reciprocal = exponent > 0 ? 1 : -1;

    double res = powerHelper(base * signal, exponent * reciprocal);

    if ((exponent & 1) != 0) res *= signal;
    if (reciprocal == -1) res = 1 / res;

    return res;
  }

  private static double powerHelper(double base, int index) {
    if (index == 0) return 1;
    if (index == 1) return base;

    // x >> 1 = x/2
    double res = powerHelper(base, index >> 1);
    // x & 1 = x % 2
    if ((index & 1) == 0) {
      res *= res;
    } else {
      res *= (res * base);
    }
    return res;
  }

  /**
   * 快速幂 迭代
   * n^x = n^0 * n^(2^1) * n^(2^2) * ... * n^(x^log_2(x))
   * <p>
   * time: O(logn)
   * space: O(logn)
   */
  public static double power2(double base, int exponent) {
    if (base == 0) return 0;
    if (exponent == 0) return 1;

    int signal = base > 0 ? 1 : -1;
    int reciprocal = exponent > 0 ? 1 : -1;

    base *= signal;
    exponent *= reciprocal;
    double res = base;

    for (int i = exponent; i > 1; i >>= 1) {
      if ((i & 1) == 0) {
        res *= res;
      } else {
        res *= (res * base);
      }
    }

    if ((exponent & 1) != 0) res *= signal;
    if (reciprocal == -1) res = 1 / res;

    return res;
  }
}
