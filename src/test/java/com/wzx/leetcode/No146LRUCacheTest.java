package com.wzx.leetcode;

import org.junit.Test;
import static com.wzx.leetcode.No146LRUCache.*;
import static org.junit.Assert.assertEquals;

public class No146LRUCacheTest {

  @Test
  public void LRUCache1() {
    LRUCache1 obj = new LRUCache1(2);
    obj.put(1, 1);
    obj.put(2, 2);
    assertEquals(1, obj.get(1));
    obj.put(3, 3);
    assertEquals(-1, obj.get(2));
    obj.put(4, 4);
    assertEquals(-1, obj.get(1));
    assertEquals(3, obj.get(3));
    assertEquals(4, obj.get(4));
  }

  @Test
  public void LRUCache2() {
    LRUCache2 obj = new LRUCache2(2);
    obj.put(1, 1);
    obj.put(2, 2);
    assertEquals(1, obj.get(1));
    obj.put(3, 3);
    assertEquals(-1, obj.get(2));
    obj.put(4, 4);
    assertEquals(-1, obj.get(1));
    assertEquals(3, obj.get(3));
    assertEquals(4, obj.get(4));
  }
}