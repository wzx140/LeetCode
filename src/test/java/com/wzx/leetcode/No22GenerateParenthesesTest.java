package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No22GenerateParenthesesTest {

  private final List<String> res1 = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
  private final List<String> res2 = Collections.singletonList("()");

  @Test
  public void generateParenthesis() {
    No22GenerateParentheses solution = new No22GenerateParentheses();
    List<String> ret1 = solution.generateParenthesis(3);
    assertTrue(res1.containsAll(ret1));
    assertTrue(ret1.containsAll(res1));
    List<String> ret2 = solution.generateParenthesis(1);
    assertTrue(res2.containsAll(ret2));
    assertTrue(ret2.containsAll(res2));
  }
}