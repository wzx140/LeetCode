package com.wzx.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * n+1位，元素大小在[1, n]数组找出重复的数字，不改变原数组，找出其中一个
 *
 * @author wzx
 */
public class No3DuplicateNum2 {

  /**
   * time: O(n)
   * space: O(n)
   */
  public static int findDuplicate1(int[] intArray) {
    Set<Integer> numSet = new HashSet<>(intArray.length);
    for (int num : intArray) {
      if (numSet.contains(num)) {
        return num;
      } else {
        numSet.add(num);
      }
    }

    return -1;
  }

  /**
   * 二分搜索+统计个数
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public static int findDuplicate2(int[] intArray) {
    if (intArray.length == 0) {
      return -1;
    }

    int end = intArray.length - 1;
    int begin = 1;

    while (begin < end){
      // 在[begin, mid]内的元素个数
      int leftNum = 0;
      int mid = (end - begin) / 2 + begin;
      // 统计个数
      for (int num : intArray) {
        if (num >= begin && num <= mid) leftNum++;
      }
      // 根据个数判断，重复的数字在[begin, mid]内还是在[begin, mid)内
      if (leftNum > mid - begin + 1) {
        end = mid;
      } else {
        begin = mid + 1;
      }
    }

    return begin;
  }
}
