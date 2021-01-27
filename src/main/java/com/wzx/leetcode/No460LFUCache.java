package com.wzx.leetcode;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/lfu-cache/">https://leetcode.com/problems/lfu-cache/</a>
 */
public class No460LFUCache {

  /**
   * 维护频率和key的映射关系
   */
  private static class FreqMap {
    // 使用LinkedHashSet维护相同频率下，key的LRU序列
    private final Map<Integer, LinkedHashSet<Integer>> freq2Key;
    private final Map<Integer, Integer> key2Freq;
    private int minFreq = 0;

    public FreqMap() {
      freq2Key = new HashMap<>();
      key2Freq = new HashMap<>();
    }

    public void increaseFreq(int key) {
      int freq = key2Freq.get(key);
      // 删除(key, freq)
      freq2Key.get(freq).remove(key);
      // 增加(key, freq + 1)
      freq2Key.putIfAbsent(freq + 1, new LinkedHashSet<>());
      freq2Key.get(freq + 1).add(key);
      key2Freq.put(key, freq + 1);
      // 更新minFreq
      if (freq2Key.get(minFreq).isEmpty()) {
        // minFreq对应的key为空, 说明刚刚访问的key对应的就是minFreq
        minFreq += 1;
      }
    }

    public int popMinFreqKey() {
      int popKey = freq2Key.get(minFreq).iterator().next();
      // 删除(key, freq)
      freq2Key.get(minFreq).remove(popKey);
      if (freq2Key.get(minFreq).isEmpty()) {
        // 只有在缓存淘汰时才会调用popMinFreqKey()
        // 所以后面一定会添加一个频率为1的新key
        minFreq = 0;
      }

      return popKey;
    }

    public void addKey(int key) {
      key2Freq.put(key, 1);
      freq2Key.putIfAbsent(1, new LinkedHashSet<>());
      freq2Key.get(1).add(key);
      minFreq = 1;
    }
  }

  /**
   * 维护key->frequency及其倒排索引, LinkedHashSet维护同一访问频率的LRU序列
   * <p>
   * time: O(1)
   * space: O(n)
   */
  public static class LFUCache {

    private final Map<Integer, Integer> KVMap;
    private final FreqMap freqMap;
    private final int capacity;

    public LFUCache(int capacity) {
      KVMap = new HashMap<>();
      freqMap = new FreqMap();
      this.capacity = capacity;
    }

    public int get(int key) {
      if (!KVMap.containsKey(key)) return -1;

      freqMap.increaseFreq(key);

      return KVMap.get(key);
    }

    public void put(int key, int value) {
      if (capacity == 0) return;

      if (!KVMap.containsKey(key)) {
        // 缓存淘汰
        if (KVMap.size() == capacity) {
          int popKey = freqMap.popMinFreqKey();
          KVMap.remove(popKey);
        }
        // 添加
        freqMap.addKey(key);
      } else {
        freqMap.increaseFreq(key);
      }

      KVMap.put(key, value);
    }
  }
}
