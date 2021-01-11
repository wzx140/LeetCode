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
    // 元素统计
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int num : nums) {
      cnt.merge(num, 1, Integer::sum);
    }

    int[] elements = cnt.keySet().stream().mapToInt(x -> x).toArray();
    int remainK = k;
    int start = 0, end = elements.length - 1;
    while (start < end) {
      int pivot = partition(elements, start, end, cnt);
      int leftNum = pivot - start + 1;

      if (leftNum > remainK) {
        // 继续划分pivot左边的数组
        end = pivot - 1;
      } else if (leftNum < remainK) {
        // 已经找到了前LeftNum的数，继续在右边数组划分前k-leftNum的数
        remainK -= leftNum;
        start = pivot + 1;
      } else {
        break;
      }
    }

    return Arrays.copyOfRange(elements, 0, k);
  }

  /**
   * 以nums[middle]划分[start, end], 返回nums[middle]
   */
  private int partition(int[] nums, int left, int right, Map<Integer, Integer> cnt) {
    int pivot = (right - left) / 2 + left;
    int record = nums[pivot];
    nums[pivot] = nums[right];
    while (left < right) {
      while (left < right && cnt.get(nums[left]) >= cnt.get(record)) left++;
      if (left < right) nums[right--] = nums[left];

      while (right > left && cnt.get(nums[right]) <= cnt.get(record)) right--;
      if (left < right) nums[left++] = nums[right];
    }
    nums[left] = record;

    return left;
  }

}
