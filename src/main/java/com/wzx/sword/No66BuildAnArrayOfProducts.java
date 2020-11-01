package com.wzx.sword;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 *
 * @author wzx
 */
public class No66BuildAnArrayOfProducts {

  /**
   * 摆脱思维定式, 构建的顺序不一定是从头至尾, 需要找出一条可以一直累乘的路径
   * b[0]=     1  A[1]  A[2]  A[3]
   * b[1]=  A[0]     1  A[2]  A[3]
   * b[2]=  A[0]  A[1]     1  A[3]
   * b[3]=  A[0]  A[1]  A[2]     1
   * 分成上下两个三角，进行两次迭代累乘并相乘
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] constructArr(int[] a) {
    int[] b = new int[a.length];
    Arrays.fill(b, 1);
    int mul = 1;
    // 上三角
    for (int i = a.length - 1; i > 0; i--) {
      mul *= a[i];
      b[i - 1] *= mul;
    }
    mul = 1;
    // 下三角
    for (int i = 0; i < a.length - 1; i++) {
      mul *= a[i];
      b[i + 1] *= mul;
    }

    return b;
  }

}
