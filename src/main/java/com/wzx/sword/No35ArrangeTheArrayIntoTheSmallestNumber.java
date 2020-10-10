package com.wzx.sword;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993
 *
 * @author wzx
 */
public class No35ArrangeTheArrayIntoTheSmallestNumber {

  /**
   * 排序组合
   *
   * time: O(nlogn)
   * space: O(n)
   */
  public String PrintMinNumber(int[] numbers) {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((num1, num2) -> {
              int i = 0, len1 = num1.length(), len2 = num2.length();
              while (i < len1 || i < len2) {
                char digit1 = i >= num1.length() ? num1.charAt(len1 - 1) : num1.charAt(i);
                char digit2 = i >= num2.length() ? num2.charAt(len2 - 1) : num2.charAt(i);
                if (digit1 != digit2) return digit1 - digit2;
                i++;
              }
              return 0;
            })
            .forEach(sb::append);

    return sb.toString();
  }
}
