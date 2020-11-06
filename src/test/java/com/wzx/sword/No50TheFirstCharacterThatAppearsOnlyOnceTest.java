package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No50TheFirstCharacterThatAppearsOnlyOnceTest {

  @Test
  public void firstUniqChar() {
    No50TheFirstCharacterThatAppearsOnlyOnce solution = new No50TheFirstCharacterThatAppearsOnlyOnce();
    assertEquals('b',solution.firstUniqChar("abaccdeff"));
    assertEquals(' ',solution.firstUniqChar(""));
  }
}