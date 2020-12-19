package com.wzx.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/
 *
 * @author wzx
 */
public class No460LFUCache {

  /**
   * 维护key->frequency及其倒排索引
   *
   * time: O(1)
   * space: O(n)
   */
  public static class LFUCache {

    private final Map<Integer, Integer> KVMap;
    private final Map<Integer, LinkedHashSet<Integer>> frequency2Key;
    private final Map<Integer, Integer> key2Frequency;
    private int minFrequency;
    private final int capacity;

    public LFUCache(int capacity) {
      this.capacity = capacity;
      minFrequency = 0;
      KVMap = new HashMap<>();
      frequency2Key = new HashMap<>();
      key2Frequency = new HashMap<>();
    }

    private void increaseFrequency(int key) {
      // 更新key2Frequency
      Integer preFrequency = key2Frequency.get(key);
      Integer newFrequency = preFrequency + 1;
      key2Frequency.put(key, newFrequency);

      // 更新frequency2Key
      frequency2Key.get(preFrequency).remove(key);
      if (!frequency2Key.containsKey(newFrequency)) {
        frequency2Key.put(newFrequency, new LinkedHashSet<>());
      }
      frequency2Key.get(newFrequency).add(key);

      // 更新minFrequency
      if (frequency2Key.get(minFrequency).isEmpty()) {
        frequency2Key.remove(minFrequency);
        minFrequency += 1;
      }
    }

    public int get(int key) {
      if (KVMap.containsKey(key)) {
        increaseFrequency(key);
        return KVMap.get(key);
      }

      return -1;
    }

    public void put(int key, int value) {
      if (capacity == 0) return;

      // 更新KV
      if (KVMap.containsKey(key)) {
        increaseFrequency(key);
        KVMap.put(key, value);
        return;
      }

      // 缓存淘汰
      if (KVMap.size() == capacity) {
        Integer eliminateKey = frequency2Key.get(minFrequency).iterator().next();
        frequency2Key.get(minFrequency).remove(eliminateKey);
        // 不需要更新计算MinFrequency
        // 因为后面会添加新KV, 一定拥有MinFrequency
        if (frequency2Key.get(minFrequency).isEmpty()) {
          frequency2Key.remove(minFrequency);
        }

        KVMap.remove(eliminateKey);
        key2Frequency.remove(eliminateKey);
      }

      // 新KV
      KVMap.put(key, value);
      key2Frequency.put(key, 1);
      if (!frequency2Key.containsKey(1)) {
        minFrequency = 1;
        frequency2Key.put(1, new LinkedHashSet<>());
      }
      frequency2Key.get(1).add(key);
    }
  }
}
