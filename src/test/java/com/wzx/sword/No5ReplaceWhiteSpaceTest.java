package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No5ReplaceWhiteSpaceTest {

  private final String data1 = " We  Are Happy ";
  private final String data2 = "hello world";
  private final String res1 = "%20We%20%20Are%20Happy%20";
  private final String res2 = "hello%20world";

  @Test
  public void testReplaceSpace() {
    No5ReplaceWhiteSpace solution = new No5ReplaceWhiteSpace();
    assertEquals(res1, solution.replaceSpace(data1));
    assertEquals(res2, solution.replaceSpace(data2));
    assertEquals("", solution.replaceSpace(""));
  }
}