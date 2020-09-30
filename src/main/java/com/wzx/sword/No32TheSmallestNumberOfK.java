package com.wzx.sword;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author wzx
 */
public class No32TheSmallestNumberOfK {

  /**
   * 先排序再取前k个
   *
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
   *
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
   * 分治
   */
  public int[] getLeastNumbers3(int[] arr, int k) {
    // todo
    return null;
  }
}
