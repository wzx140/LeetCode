package com.wzx.leetcode;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/">https://leetcode.com/problems/find-median-from-data-stream/</a>
 * @author wzx
 */
public class No295FindMedianFromDataStream {

  /**
   * 一个大跟堆，一个小根堆
   * <p>
   * space: O(n)
   */
  public static class MedianFinder {

    private final Queue<Integer> largeQueue;
    private final Queue<Integer> smallQueue;

    public MedianFinder() {
      largeQueue = new PriorityQueue<>((x1, x2) -> x2 - x1);
      smallQueue = new PriorityQueue<>();
    }

    /**
     * time: O(logn)
     */
    public void addNum(int num) {
      if (num > findMedian()) {
        smallQueue.add(num);
      } else {
        largeQueue.add(num);
      }

      if (Math.abs(largeQueue.size() - smallQueue.size()) > 1) {
        reBalance();
      }
    }

    private void reBalance() {
      if (largeQueue.size() > smallQueue.size()) {
        smallQueue.add(largeQueue.poll());
      } else {
        largeQueue.add(smallQueue.poll());
      }
    }

    /**
     * time: O(1)
     */
    public double findMedian() {
      if (largeQueue.size() == smallQueue.size()) {
        return (Optional.ofNullable(largeQueue.peek()).orElse(0)
                + Optional.ofNullable(smallQueue.peek()).orElse(0)) / 2.;
      } else {
        return largeQueue.size() > smallQueue.size() ? largeQueue.peek() : smallQueue.peek();
      }
    }
  }
}
