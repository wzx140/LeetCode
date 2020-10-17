package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No9TwoStackImplementQueueTest {

  @Test
  public void testCQueue() {
    No9TwoStackImplementQueue.CQueue queue = new No9TwoStackImplementQueue.CQueue();
    queue.appendTail(3);
    assertEquals(3, queue.deleteHead());
    assertEquals(-1, queue.deleteHead());

    queue.clear();
    assertEquals(-1, queue.deleteHead());
    queue.appendTail(5);
    queue.appendTail(2);
    assertEquals(5, queue.deleteHead());
    assertEquals(2, queue.deleteHead());
  }
}