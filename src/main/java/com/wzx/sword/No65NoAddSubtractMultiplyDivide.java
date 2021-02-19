package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/">https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/</a>
 * @author wzx
 */
public class No65NoAddSubtractMultiplyDivide {

  /**
   * 非进位和 a ^ b
   * 已经进位的进位和 (a & b) << 1
   * 迭代求解直到没有进位和, 非进位和即为和
   *
   * time: O(1)
   * space: O(1)
   */
  public int add(int a, int b) {
    if (b == 0) return a;

    return add(a ^ b, (a & b) << 1);
  }
}
