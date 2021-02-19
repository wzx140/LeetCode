package com.wzx.sword;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/">https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/</a>
 * @author wzx
 */
public class No45ArrangeTheArrayIntoTheSmallestNumber {

  /**
   * 排序组合
   * <p>
   * time: O(nlogn)
   * space: O(n)
   */
  public String minNumber(int[] nums) {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .sorted((num1, num2) -> {
              int i = 0, len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
              while (i < len) {
                // 比较 num1+num2 num2+num1
                char digit1 = i >= num1.length() ? num2.charAt(i - len1) : num1.charAt(i);
                char digit2 = i >= num2.length() ? num1.charAt(i - len2) : num2.charAt(i);
                if (digit1 != digit2) return digit1 - digit2;
                i++;
              }
              return 0;
            })
            .forEach(sb::append);

    return sb.toString();
  }
}
