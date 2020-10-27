package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No59MaximumValueOfTheQueueTest {
  @Test
  public void maxQueue() {
    No59MaximumValueOfTheQueue.MaxQueue maxQueue = new No59MaximumValueOfTheQueue.MaxQueue();
    maxQueue.push_back(1);
    maxQueue.push_back(2);
    assertEquals(2, maxQueue.max_value());
    assertEquals(1, maxQueue.pop_front());
    assertEquals(2, maxQueue.max_value());

    maxQueue = new No59MaximumValueOfTheQueue.MaxQueue();
    assertEquals(-1, maxQueue.pop_front());
    assertEquals(-1, maxQueue.max_value());

    maxQueue = new No59MaximumValueOfTheQueue.MaxQueue();
    maxQueue.push_back(15);
    assertEquals(15, maxQueue.max_value());
    maxQueue.push_back(9);
    assertEquals(15, maxQueue.max_value());
  }
}