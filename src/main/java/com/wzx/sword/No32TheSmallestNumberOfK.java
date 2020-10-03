package com.wzx.sword;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author wzx
 */
public class No32TheSmallestNumberOfK {

  /**
   * 先排序再取前k个
   * <p>
   * time: O(nlong)
   * space: O(1)
   */
  public int[] getLeastNumbers1(int[] arr, int k) {
    return Arrays.stream(arr)
            .sorted()
            .limit(Math.min(k, arr.length))
            .toArray();
  }

  /**
   * 堆排序
   * <p>
   * time: O(nlogn)
   * space: O(n)
   */
  public int[] getLeastNumbers2(int[] arr, int k) {
    Queue<Integer> minHeap = new PriorityQueue<>(arr.length);
    Arrays.stream(arr).forEach(minHeap::add);

    return IntStream.generate(minHeap::poll)
            .limit(Math.min(k, arr.length))
            .toArray();
  }

  /**
   * 类似快排的想法
   * <p>
   * time: O(n)
   * space: O(logn)
   */
  public int[] getLeastNumbers3(int[] arr, int k) {

    k = Math.min(k, arr.length);
    recursion(arr, 0, arr.length - 1, k);

    return Arrays.copyOfRange(arr, 0, k);
  }

  private void recursion(int[] arr, int left, int right, int k) {
    if (left >= right) return;
    int pivot = partitioned(arr, left, right);
    // left~pivot的数目
    int num = pivot - left + 1;
    if (num > k) {
      recursion(arr, left, pivot - 1, k);
    } else if (num < k) {
      // k - pivot左边的数目
      recursion(arr, pivot + 1, right, k - num);
    }
  }

  /**
   * 选择轴值，小于轴值的元素放在左边，大于轴值的放在右边，返回轴值的相对索引
   */
  private int partitioned(int[] arr, int left, int right) {
    int pivot = left + (right - left) / 2;
    int record = arr[pivot];

    arr[pivot] = arr[right];
    while (left < right) {
      // 交替执行
      while (arr[left] < record && left < right) left++;
      if (left < right) {
        arr[right--] = arr[left];
      }

      while (arr[right] > record && left < right) right--;
      if (left < right) {
        arr[left++] = arr[right];
      }
    }
    arr[left] = record;

    return left;
  }
}
