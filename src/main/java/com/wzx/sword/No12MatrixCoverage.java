package com.wzx.sword;

/**
 * @see <a href="https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6">https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6</a>
 * @author wzx
 */
public class No12MatrixCoverage {

  /**
   * 找规律，然后动归
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static int rectCover(int target) {
    if (target < 3) return target;
    int r1 = 1;
    int r2 = 2;

    for (int i = 3; i <= target; i++) {
      int tmp = r2;
      r2 = r1 + r2;
      r1 = tmp;
    }

    return r2;
  }
}
