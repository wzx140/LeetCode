package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/3sum-with-multiplicity/">https://leetcode.com/problems/3sum-with-multiplicity/</a>
 * @author wzx
 */
public class No923ThreeSumWithMultiplicity {

  /**
   * 左右指针
   *
   * time: O(n^2)
   * space: O(1)
   */
  public int threeSumMulti(int[] A, int target) {
    int MOD = 1_000_000_007;
    Arrays.sort(A);
    int res = 0;

    // 先确定一个数，再使用2sum的左右指针
    for (int i = 0; i < A.length; i++) {

      int left = i + 1, right = A.length - 1;
      while (left < right) {
        int sum = A[i] + A[left] + A[right];
        if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
          // A[left] + A[right] + A[i] = target
        } else if (A[left] != A[right]) {
          // a=A[left],b=A[right]  a, a, a,..., b, b,... 共有count(a)*count(b)种选择方案
          int cntLeft = 1, cntRight = 1;
          while (left + 1 < right && A[left] == A[left + 1]) {
            cntLeft++;
            left++;
          }
          while (right - 1 > left && A[right] == A[right - 1]) {
            cntRight++;
            right--;
          }
          res += cntLeft * cntRight;
          res %= MOD;
          left++;
          right--;
        } else {
          // a=right-left+1, 共有1+2+...+a-1=a(a-1)/2中选择方案
          int m = right - left + 1;
          res += (m - 1) * m / 2;
          res %= MOD;
          break;
        }
      }
    }

    return res;
  }

}
