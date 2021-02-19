package com.wzx.leetcode;

import com.wzx.entity.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">https://leetcode.com/problems/top-k-frequent-elements/</a>
 */
public class No347TopKFrequentElements {

  /**
   * 最大堆
   * <p>
   * time: O(nlogk)
   * space: O(n)
   */
  public int[] topKFrequent1(int[] nums, int k) {
    // 统计出现频率
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int num : nums) {
      cnt.merge(num, 1, Integer::sum);
    }

    // 最大堆大小为k, 建堆
//    Heap<Integer> maxHeap = new Heap<>(cnt.keySet(),
//            (k1, k2) -> cnt.get(k2) - cnt.get(k1));
    Heap<Integer> maxHeap = new Heap<>(cnt.size(),
            (k1, k2) -> cnt.get(k2) - cnt.get(k1));
    for (Integer num : cnt.keySet()) {
      maxHeap.add(num);
    }
    // 取出最大堆中的频率最大的k个数
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = maxHeap.peek();
      maxHeap.pop();
    }
    return res;
  }

  /**
   * 快排思想
   * <p>
   * time: O(n)
   * space: O(N)
   */
  public int[] topKFrequent2(int[] nums, int k) {
    // 统计
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int num : nums) {
      cnt.merge(num, 1, Integer::sum);
    }

    int[] elements = cnt.keySet().stream().mapToInt(x -> x).toArray();
    helper(elements, 0, elements.length - 1, k, cnt);
    return Arrays.copyOfRange(elements, 0, k);
  }

  private void helper(int[] nums, int start, int end, int k, Map<Integer, Integer> cnt) {
    // 快排
    if (start >= end) return;

    int pivot = (end - start) / 2 + start;
    int record = nums[pivot];
    int left = start, right = end;
    nums[pivot] = nums[right];
    while (left < right) {
      while (left < right && cnt.get(nums[left]) >= cnt.get(record)) left++;
      if (left < right) {
        nums[right--] = nums[left];
      }
      while (left < right && cnt.get(nums[right]) < cnt.get(record)) right--;
      if (left < right) {
        nums[left++] = nums[right];
      }
    }
    nums[left] = record;
    // 根据轴值及其左侧个数递归排序
    int leftNum = left - start + 1;
    if (leftNum > k) {
      // 继续划分左侧
      helper(nums, start, left - 1, k, cnt);
    } else if (leftNum < k) {
      // 已经提取出来前leftNum个元素, 继续从右侧提取k-leftNum
      helper(nums, left + 1, end, k - leftNum, cnt);
    }
  }

}
