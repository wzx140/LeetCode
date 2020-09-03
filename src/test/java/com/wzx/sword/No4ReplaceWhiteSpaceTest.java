package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No4ReplaceWhiteSpaceTest {

  private final String data1 = " We  Are Happy ";
  private final String data2 = "hello world";
  private final String res1 = "%20We%20%20Are%20Happy%20";
  private final String res2 = "hello%20world";

  @Test
  public void replaceSpace1() {
    assertEquals(res1, No4ReplaceWhiteSpace.replaceSpace1(new StringBuffer(data1)));
    assertEquals(res2, No4ReplaceWhiteSpace.replaceSpace1(new StringBuffer(data2)));
    assertEquals("", No4ReplaceWhiteSpace.replaceSpace1(new StringBuffer()));
  }

  @Test
  public void testReplaceSpace2() {
    assertEquals(res1, No4ReplaceWhiteSpace.replaceSpace2(new StringBuffer(data1)));
    assertEquals(res2, No4ReplaceWhiteSpace.replaceSpace2(new StringBuffer(data2)));
    assertEquals("", No4ReplaceWhiteSpace.replaceSpace1(new StringBuffer()));
  }
}