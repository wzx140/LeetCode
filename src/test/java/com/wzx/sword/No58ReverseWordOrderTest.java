package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No58ReverseWordOrderTest {

  private final String str1 = "the sky is blue";
  private final String res1 = "blue is sky the";
  private final String str2 = "  hello world!  ";
  private final String res2 = "world! hello";
  private final String str3 = "a good   example";
  private final String res3 = "example good a";

  @Test
  public void reverseWords() {
    No58ReverseWordOrder solution = new No58ReverseWordOrder();
    assertEquals(res1, solution.reverseWords(str1));
    assertEquals(res2, solution.reverseWords(str2));
    assertEquals(res3, solution.reverseWords(str3));
  }
}