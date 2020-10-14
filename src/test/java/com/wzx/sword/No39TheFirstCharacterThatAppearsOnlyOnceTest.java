package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No39TheFirstCharacterThatAppearsOnlyOnceTest {

  @Test
  public void firstUniqChar() {
    No39TheFirstCharacterThatAppearsOnlyOnce solution = new No39TheFirstCharacterThatAppearsOnlyOnce();
    assertEquals('b',solution.firstUniqChar("abaccdeff"));
    assertEquals(' ',solution.firstUniqChar(""));
  }
}