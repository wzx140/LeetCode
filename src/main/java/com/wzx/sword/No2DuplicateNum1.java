package com.wzx.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * n位，元素大小在[0, n-1]的数组中重复的数字，找出其中一个
 *
 * @author wzx
 */
public class No2DuplicateNum1 {

  /**
   * time: O(nlogn)
   * space: O(1)
   */
  public static int findDuplicate1(int[] intArray) {
    Arrays.sort(intArray);

    for (int i = 1; i < intArray.length; i++) {
      if (intArray[i] == intArray[i - 1]) {
        return intArray[i];
      }
    }

    return -1;
  }

  /**
   * time: O(n)
   * space: O(n)
   */
  public static int findDuplicate2(int[] intArray) {
    Set<Integer> numSet = new HashSet<>();
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
   * 由于数字在0~n-1之间，以数组下标作为标记，可以作为重复判断的依据。
   * 每次常数时间复杂度内都可以将某一元素放到正确的位置，所以最差情况下时间复杂度为O(n)
   *
   * time: O(n)
   * space: O(1)
   */
  public static int findDuplicate3(int[] intArray) {
    for (int i = 0; i < intArray.length; i++) {
      // 重复直到当前下标与值对应
      while (i != intArray[i]) {
        int num = intArray[i];
        if (num == intArray[num]) {
          return num;
        } else {
          // 当前下标的值移动到它应该在的下标位置
          intArray[i] = intArray[num];
          intArray[num] = num;
        }
      }
    }

    return -1;
  }
}
