package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No30MinStackTest {

  @Test
  public void minStack() {
    No30MinStack.MinStack stack = new No30MinStack.MinStack();
    stack.push(4);
    assertEquals(4, stack.top());
    assertEquals(4, stack.min());
    stack.push(2);
    assertEquals(2, stack.top());
    assertEquals(2, stack.min());
    stack.push(3);
    assertEquals(3, stack.top());
    assertEquals(2, stack.min());
    stack.push(1);
    assertEquals(1, stack.top());
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(3, stack.top());
    assertEquals(2, stack.min());
    stack.pop();
    assertEquals(2, stack.top());
    assertEquals(2, stack.min());
    stack.pop();
    assertEquals(4, stack.top());
    assertEquals(4, stack.min());

    stack = new No30MinStack.MinStack();
    stack.push(-2);
    stack.push(0);
    stack.push(-1);
    assertEquals(-2, stack.min());
    assertEquals(-1, stack.top());
    stack.pop();
    assertEquals(-2, stack.min());
  }
}