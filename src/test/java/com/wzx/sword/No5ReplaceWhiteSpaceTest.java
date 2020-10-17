package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No5ReplaceWhiteSpaceTest {

  private final String data1 = " We  Are Happy ";
  private final String data2 = "hello world";
  private final String res1 = "%20We%20%20Are%20Happy%20";
  private final String res2 = "hello%20world";

  @Test
  public void replaceSpace1() {
    No5ReplaceWhiteSpace solution = new No5ReplaceWhiteSpace();
    assertEquals(res1, solution.replaceSpace1(new StringBuffer(data1)));
    assertEquals(res2, solution.replaceSpace1(new StringBuffer(data2)));
    assertEquals("", solution.replaceSpace1(new StringBuffer()));
  }

  @Test
  public void testReplaceSpace2() {
    No5ReplaceWhiteSpace solution = new No5ReplaceWhiteSpace();
    assertEquals(res1, solution.replaceSpace2(new StringBuffer(data1)));
    assertEquals(res2, solution.replaceSpace2(new StringBuffer(data2)));
    assertEquals("", solution.replaceSpace1(new StringBuffer()));
  }
}