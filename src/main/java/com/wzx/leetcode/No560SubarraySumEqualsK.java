package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * @author wzx
 */
public class No560SubarraySumEqualsK {

  /**
   * 前缀和数组能在O(1)内确定子数组的和: sum(i, j) = prefixSum[j] - prefixSum[i]
   * sum(i, j)=k => prefixSum[j]-prefixSum[i]=k => prefixSum[i]=prefixSum[j]-k
   * 这里就转化为了类似two sum问题, 利用哈希表保存prefixSum就可以快速找到prefixSum[i]
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int subarraySum(int[] nums, int k) {
    // prefix sum -> count
    Map<Integer, Integer> prefixSumMap = new HashMap<>();
    prefixSumMap.put(0, 1);
    int nextPrefixSum = 0;
    int cnt = 0;
    for (int num : nums) {
      nextPrefixSum += num;
      cnt += prefixSumMap.getOrDefault(nextPrefixSum - k, 0);
      prefixSumMap.merge(nextPrefixSum, 1, Integer::sum);
    }

    return cnt;
  }
}
