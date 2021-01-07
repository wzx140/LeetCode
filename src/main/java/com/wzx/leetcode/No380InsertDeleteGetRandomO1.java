package com.wzx.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">https://leetcode.com/problems/insert-delete-getrandom-o1/</a>
 * @author wzx
 */
public class No380InsertDeleteGetRandomO1 {

  /**
   * 连续存储才能做到O(1)等概率随机
   */
  public static class RandomizedSet {

    private final List<Integer> data;
    private final Map<Integer,Integer> val2Index;
    private final Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
      data = new ArrayList<>();
      val2Index = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (val2Index.containsKey(val)) return false;
      // 新元素插入到最后
      data.add(val);
      val2Index.put(val, data.size() - 1);
      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!val2Index.containsKey(val)) return false;
      // 删除的元素和最后一个元素交换并删除
      int last = data.get(data.size() - 1);
      data.set(val2Index.get(val), last);
      val2Index.put(last, val2Index.get(val));
      data.remove(data.size() - 1);
      val2Index.remove(val);
      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return data.get(random.nextInt(data.size()));
    }
  }
}
