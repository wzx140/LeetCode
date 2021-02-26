package com.wzx.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/sort-an-array/">https://leetcode.com/problems/sort-an-array/</a>
 * @author wzx
 */
public class No912SortAnArray {

  //
  // *****插入排序*****
  //

  /**
   * 直接插入排序
   * <p>
   * time: O(n^2)
   * space: O(1)
   * 稳定
   */
  public int[] sortArray1(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      // 将元素插入到有序序列的合适位置
      int record = nums[i];
      int j = i - 1;
      // 空出插入位置
      while (j >= 0 && nums[j] > record) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = record;
    }

    return nums;
  }

  /**
   * shell排序
   * <p>
   * time: O(nlogn)
   * space: O(1)
   * 不稳定
   */
  public int[] sortArray2(int[] nums) {
    // 间隔
    for (int delta = nums.length / 2; delta > 0; delta /= 2) {
      // 起始位置
      for (int start = 0; start < delta; start++) {
        // 以相距为delta的序列应用插入排序
        for (int i = start + delta; i < nums.length; i += delta) {
          int record = nums[i];
          int j = i - delta;
          while (j >= 0 && nums[j] > record) {
            nums[j + delta] = nums[j];
            j -= delta;
          }
          nums[j + delta] = record;
        }
      }
    }

    return nums;
  }

  //
  // *****选择排序*****
  //

  /**
   * 直接选择排序
   * <p>
   * time: O(n^2)
   * space: O(1)
   * 不稳定
   */
  public int[] sortArray3(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // 找到序列[i:]中最小的元素
      int minValue = nums[i], minIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < minValue) {
          minIndex = j;
          minValue = nums[j];
        }
      }
      // 将最小元素放到序列[i:]最前
      swap(nums, i, minIndex);
    }

    return nums;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  /**
   * 堆排序, 最小堆的实现参见347. Top K Frequent Elements
   * <p>
   * time: O(nlogn)
   * space: O(logn)
   * 不稳定
   */
  public int[] sortArray4(int[] nums) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
    for (int num : nums) {
      queue.add(num);
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = queue.poll();
    }
    return nums;
  }

  //
  // *****交换排序*****
  //

  /**
   * 冒泡排序
   * <p>
   * time: O(n^2) 超时
   * space: O(1)
   * 稳定
   */
  public int[] sortArray5(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      boolean swap = false;
      // 冒泡, 将较小的值向上传递
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[j] < nums[j - 1]) {
          swap(nums, j, j - 1);
          swap = true;
        }
      }
      // 不发生交换说明已经排序完成
      if (!swap) break;
    }

    return nums;
  }

  /**
   * 快速排序
   * <p>
   * time: O(nlogn)
   * space: O(logn)
   * 不稳定
   */
  public int[] sortArray6(int[] nums) {
    recursion(nums, 0, nums.length - 1);
    return nums;
  }

  private void recursion(int[] nums, int start, int end) {
    if (start >= end) return;
    // 轴值
    int pivot = (end - start) / 2 + start;

    int left = start, right = end;
    int record = nums[pivot];
    nums[pivot] = nums[right];
    // 以轴值处为分割点, 小于轴值的记录放在左边, 大于轴值的记录放在右边
    while (left < right) {
      while (left < right && nums[left] <= record) left++;
      if (left < right) {
        nums[right] = nums[left];
        right--;
      }
      while (left < right && nums[right] >= record) right--;
      if (left < right) {
        nums[left] = nums[right];
        left++;
      }
    }
    nums[left] = record;

    // 以交换后的轴值位置为分割
    recursion(nums, start, left - 1);
    recursion(nums, left + 1, end);
  }

  //
  // *****分配排序*****
  //

  /**
   * 计数排序
   * <p>
   * time: O(n+m)
   * space: O(n+m)
   * 稳定
   */
  public int[] sortArray7(int[] nums) {
    int min = -50000, max = 50000;
    // 排序码统计计数
    int[] count = new int[max - min];
    for (int num : nums) {
      count[num - min]++;
    }
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }
    // 按照count数组中的计数重新指定数组的顺序
    int[] tmp = nums.clone();
    // 由后至前遍历, 保证稳定性
    for (int i = nums.length - 1; i >= 0; i--) {
      nums[count[tmp[i] - min] - 1] = tmp[i];
      count[tmp[i] - min]--;
    }

    return nums;
  }

  /**
   * 基数排序
   * <p>
   * time: O(k(n+r)) k个基数, 每个基数取值范围r
   * space: O(k(n+r))
   * 稳定
   */
  public int[] sortArray8(int[] nums) {
    // 基数
    int radix = 10;
    // 基数个数
    int radixNum = (int) Math.ceil(Math.log(50000) / Math.log(radix));
    // 基数内取值范围
    int minR = -(radix - 1), maxR = radix + 1;

    int[] count = new int[maxR - minR];
    // 高位的排序不会影响次高位已经排好的大小关系
    for (int curR = 0; curR <= radixNum; curR++) {
      Arrays.fill(count, 0);
      // 每个基数内应用桶排序
      for (int num : nums) {
        int k = num / (int) Math.pow(radix, curR) % radix;
        count[k - minR]++;
      }
      for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
      }
      // 按照count数组中的计数重新指定数组的顺序
      int[] tmp = nums.clone();
      // 从后至前指定数组顺序, 保证排序稳定性
      for (int i = nums.length - 1; i >= 0; i--) {
        int k = tmp[i] / (int) Math.pow(radix, curR) % radix;
        nums[count[k - minR] - 1] = tmp[i];
        count[k - minR]--;
      }
    }
    return nums;
  }

  //
  // *****归并排序*****
  //

  /**
   * 归并排序
   * <p>
   * time: O(nlogn)
   * space: O(n)
   * 稳定
   */
  public int[] sortArray9(int[] nums) {
    recursion(nums, 0, nums.length - 1, new int[nums.length]);
    return nums;
  }

  private void recursion(int[] nums, int start, int end, int[] tmp) {
    if (start >= end) return;
    int middle = (end - start) / 2 + start;
    recursion(nums, start, middle, tmp);
    recursion(nums, middle + 1, end, tmp);
    merge(nums, start, end, middle, tmp);
  }

  private void merge(int[] nums, int start, int end, int middle, int[] tmp) {
    // [start, middle]正序放入tmp, [middle+1, end]反序放入tmp
    for (int i = start; i <= middle; i++) {
      tmp[i] = nums[i];
    }
    int index = middle + 1;
    for (int i = end; i > middle; i--) {
      tmp[index++] = nums[i];
    }
    // 二路归并
    int left = start, right = end, curIndex = start;
    while (left <= right) {
      if (tmp[left] <= tmp[right]) {
        nums[curIndex] = tmp[left];
        left++;
      } else {
        nums[curIndex] = tmp[right];
        right--;
      }
      curIndex++;
    }
  }
}
