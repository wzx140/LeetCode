package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author wzx
 */
public class No347TopKFrequentElements {

  /**
   * 最大堆
   * <p>
   * time: O(nlogn)
   * space: O(n)
   */
  public int[] topKFrequent1(int[] nums, int k) {
    // 元素统计
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int num : nums) {
      cnt.merge(num, 1, Integer::sum);
    }

    // 筛选法建堆
    // 最大堆大小
    int size = cnt.size();
    int[] heap = new int[size];
    Set<Integer> elements = cnt.keySet();
    int index = 0;
    // 建堆
    for (Integer element : elements) {
      heap[index++] = element;
    }
    for (int i = size / 2 - 1; i >= 0; i--) {
      siftDown(i, heap, size, cnt);
    }
    // 最大堆的取出和删除
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = heap[0];
      heap[0] = heap[--size];
      siftDown(0, heap, size, cnt);
    }

    return res;
  }

  /**
   * 从第i个树节点往下调整
   */
  private void siftDown(int i, int[] heap, int size, Map<Integer, Integer> cnt) {
    int parent = i;
    // 左子结点
    int child = 2 * parent + 1;
    // 当前结点值暂存
    int tmp = heap[parent];

    while (child < size) {
      // 取左右子结点中较大的一个
      if (child < size - 1 && cnt.get(heap[child]) < cnt.get(heap[child + 1])) {
        child = child + 1;
      }
      // 若当前结点较小，则向下传播
      if (cnt.get(tmp) < cnt.get(heap[child])) {
        heap[parent] = heap[child];
        parent = child;
        child = 2 * parent + 1;
      } else {
        break;
      }
    }

    heap[parent] = tmp;
  }

  /**
   * 快排思想
   *
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
