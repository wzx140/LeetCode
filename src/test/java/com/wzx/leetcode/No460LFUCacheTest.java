package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No460LFUCacheTest {

  @Test
  public void LFU() {
    No460LFUCache.LFUCache lfuCache = new No460LFUCache.LFUCache(2);
    lfuCache.put(1, 1);
    lfuCache.put(2, 2);
    assertEquals(1, lfuCache.get(1));
    lfuCache.put(3, 3);
    assertEquals(-1, lfuCache.get(2));
    assertEquals(3, lfuCache.get(3));
    lfuCache.put(4, 4);
    assertEquals(-1, lfuCache.get(1));
    assertEquals(3, lfuCache.get(3));
    assertEquals(4, lfuCache.get(4));
  }
}