package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-blacklist/
 *
 * @author wzx
 */
public class No710RandomPickWithBlacklist {

  /**
   * 连续存储能做到O(1)等概率随机
   * 利用map映射, 将不在黑名单的元素集中到前N-blacklist中
   */
  public static class Solution {

    private final Map<Integer, Integer> black2sz;
    private final Random random = new Random();
    private final int size;

    public Solution(int N, int[] blacklist) {
      black2sz = new HashMap<>();
      // 建立blacklist的hashset
      for (int black : blacklist) {
        black2sz.put(black, -1);
      }

      size = N - blacklist.length;
      int last = N - 1;
      for (int black : blacklist) {
        // 将在N-blacklist内的黑名单元素映射为N-blacklist外的非黑名单元素
        if (black <= size - 1) {
          // 找到N-blacklist外的非黑名单元素
          while (black2sz.containsKey(last)) {
            last--;
          }
          black2sz.put(black, last);
          last--;
        }
      }
    }

    public int pick() {
      int rand = random.nextInt(size);
      // 如果不在blacklist直接返回, 否则进行映射
      return black2sz.getOrDefault(rand, rand);
    }
  }
}
