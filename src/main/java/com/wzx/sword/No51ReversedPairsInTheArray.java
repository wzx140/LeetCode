package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/">https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/</a>
 * @author wzx
 */
public class No51ReversedPairsInTheArray {

  /**
   * 在归并排序过程中计算逆序对。在两个有序数组归并过程中，可以判断某个元素的逆序数而不用遍历整个数组
   * <p>
   * time: O(nlong)
   * space: O(n)
   */
  public int reversePairs(int[] nums) {
    return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int[] tmp, int begin, int end) {
    if (begin >= end) return 0;

    int middle = begin + (end - begin) / 2;
    int leftInverse = mergeSort(nums, tmp, begin, middle);
    int rightInverse = mergeSort(nums, tmp, middle + 1, end);
    int crossInverse = merge(nums, tmp, begin, end, middle);

    return leftInverse + rightInverse + crossInverse;
  }

  private int merge(int[] nums, int[] tmp, int begin, int end, int middle) {
    if (begin >= end) return 0;

    // 左序列正序，右序列倒序。在后面归并的时候可以互为哨兵
    for (int i = begin; i <= middle; i++) {
      tmp[i] = nums[i];
    }
    for (int i = middle + 1; i <= end; i++) {
      tmp[end - (i - middle) + 1] = nums[i];
    }

    // 左右序列从两边向中间方向，归并
    int left = begin, right = end;
    int inverseNum = 0;
    while (begin <= end) {
      if (tmp[left] <= tmp[right]) {
        nums[begin++] = tmp[left++];
      } else {
        nums[begin++] = tmp[right--];
        // 右序列的元素比左序列的元素要小时，左序列[left, middle]都是右序列中此元素的逆序对
        inverseNum += middle - left + 1;
      }
    }

    return inverseNum;
  }
}
