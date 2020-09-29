package com.wzx.sword;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class No30StringArrangementTest {

  private final String str = "abc";
  private final ArrayList<String> res = new ArrayList<String>() {{
    add("abc");
    add("acb");
    add("bac");
    add("bca");
    add("cab");
    add("cba");
  }};

  @Test
  public void permutation() {
    No30StringArrangement solution = new No30StringArrangement();
    assertEquals(res, solution.Permutation(str));
  }
}