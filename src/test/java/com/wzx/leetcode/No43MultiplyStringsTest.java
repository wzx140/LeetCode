package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No43MultiplyStringsTest {

  @Test
  public void multiply() {
    No43MultiplyStrings solution = new No43MultiplyStrings();
    assertEquals("6", solution.multiply("2", "3"));
    assertEquals("56088", solution.multiply("123", "456"));
  }
}