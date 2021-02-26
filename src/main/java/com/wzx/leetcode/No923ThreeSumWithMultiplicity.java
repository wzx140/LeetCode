package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/3sum-with-multiplicity/">https://leetcode.com/problems/3sum-with-multiplicity/</a>
 * @author wzx
 */
public class No923ThreeSumWithMultiplicity {

  /**
   * 左右指针
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public int threeSumMulti(int[] arr, int target) {
    int MOD = 1_000_000_007;
    Arrays.sort(arr);
    int res = 0;

    // 先确定一个数，再使用2sum的左右指针
    for (int i = 0; i < arr.length; i++) {

      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        int sum = arr[i] + arr[left] + arr[right];
        if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
          // arr[left] + arr[right] + arr[i] = target
        } else if (arr[left] != arr[right]) {
          // a=arr[left],b=arr[right]  a, a, a,..., b, b,... 共有count(a)*count(b)种选择方案
          int cntLeft = 1, cntRight = 1;
          while (left < right - 1 && arr[left] == arr[left + 1]) {
            cntLeft++;
            left++;
          }
          while (left + 1 < right && arr[right] == arr[right - 1]) {
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
