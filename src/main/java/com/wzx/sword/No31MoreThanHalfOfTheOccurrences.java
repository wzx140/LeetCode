package com.wzx.sword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 *
 * @author wzx
 */
public class No31MoreThanHalfOfTheOccurrences {

  /**
   * 哈希表储存计数
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int MoreThanHalfNum_Solution1(int[] array) {
    Map<Integer, Integer> cnt = new HashMap<>(array.length);
    int threshold = array.length / 2;
    for (int num : array) {
      int newVal = cnt.merge(num, 1, (oldVal, defaultVal) -> oldVal + 1);
      if (newVal > threshold) return num;
    }
    return 0;
  }

  /**
   * 先排序再判断
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public int MoreThanHalfNum_Solution2(int[] array) {
    Arrays.sort(array);
    int cnt = 0, cur = 0;
    int threshold = array.length / 2;
    for (int num : array) {
      if (num == cur) {
        cnt++;
      } else {
        cur = num;
        cnt = 1;
      }
      if (cnt > threshold) return num;
    }

    return 0;
  }

  /**
   * 出现次数超过数组长度一半，说明该数个数大于其他所有数的总和
   * 遍历数组，每次删除两个不同的数，超过n/2次数的数一定是剩下的数(注意这是必要不充分条件)
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int MoreThanHalfNum_Solution3(int[] array) {
    // 候选众数和计数
    int cur = 0;
    int cnt = 0;

    for (int num : array) {

      if (num != cur && cnt == 0) {
        // 前一个候选众数已经被删除完
        cur = num;
        cnt = 1;
      } else if (num != cur && cnt > 0) {
        // 消去一个众数和非众数
        cnt--;
      } else {
        cnt++;
      }

    }

    cnt = 0;
    for (int num : array) {
      if (num == cur) cnt++;
    }

    return cnt > array.length / 2 ? cur : 0;
  }
}
