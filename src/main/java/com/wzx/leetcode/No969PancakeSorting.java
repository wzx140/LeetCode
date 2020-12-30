package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 *
 * @author wzx
 */
public class No969PancakeSorting {

  /**
   * 递归
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public List<Integer> pancakeSort(int[] arr) {
    List<Integer> res = new LinkedList<>();
    recursion(arr, arr.length, res);
    return res;
  }

  /**
   * 翻转两次使最大的煎饼处在k层
   */
  private void recursion(int[] arr, int k, List<Integer> res) {
    if (k == 1) return;
    // 找到最大煎饼
    int maxIndex = 0, maxValue = 0;
    for (int i = 1; i <= k; i++) {
      if (arr[i - 1] > maxValue) {
        maxIndex = i;
        maxValue = arr[i - 1];
      }
    }
    // 把最大煎饼翻到第1层
    reverse(arr, maxIndex);
    res.add(maxIndex);
    // 再整个翻下来
    reverse(arr, k);
    res.add(k);

    recursion(arr, k - 1, res);
  }

  private void reverse(int[] arr, int k) {
    int i = 0, j = k - 1;
    while (i < j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
  }
}
