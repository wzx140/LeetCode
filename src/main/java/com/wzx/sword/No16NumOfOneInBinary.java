package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8
 *
 * @author wzx
 */
public class No16NumOfOneInBinary {

  /**
   * 不断右移与1做按位与，注意>>对于负数是高位补1
   *
   * time: O(n)
   * space: O(1)
   */
  public static int NumberOf1(int n) {
    int num = 0;

    while (n != 0) {
      if ((n & 1) != 0) num += 1;
      n >>>= 1;
    }

    return num;
  }

  /**
   * 把一个整数减去1之后再后原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的1变成0
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static int NumberOf2(int n) {
    int cnt = 0;

    while (n != 0) {
      cnt++;
      n = n & (n - 1);
    }

    return cnt;
  }
}
