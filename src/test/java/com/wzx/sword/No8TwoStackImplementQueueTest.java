package com.wzx.sword;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class No8TwoStackImplementQueueTest {

  @Test
  public void testQueue() {
    No8TwoStackImplementQueue.MockQueue queue = new No8TwoStackImplementQueue.MockQueue();
    queue.push(1);
    assertEquals(1,queue.pop());
    queue.push(1);
    queue.push(2);
    queue.push(3);
    assertEquals(1,queue.pop());
    assertEquals(2,queue.pop());
    assertEquals(3,queue.pop());
  }

  @Test(expected = NoSuchElementException.class)
  public void testEmpty() {
    No8TwoStackImplementQueue.MockQueue queue = new No8TwoStackImplementQueue.MockQueue();
    queue.push(1);
    queue.pop();
    queue.pop();
  }
}