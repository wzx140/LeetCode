package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No13MatrixPathTest {

  private final char[] matrix1 = new char[]{'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
  private final char[] target11 = new char[]{'b', 'f', 'c', 'e'};
  private final char[] target12 = new char[]{'a', 'b', 'c', 'b'};

  private final char[] matrix2 = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
  private final char[] target21 = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};


  @Test
  public void hasPath() {
    assertTrue(No13MatrixPath.hasPath(matrix1, 3, 4, target11));
    assertFalse(No13MatrixPath.hasPath(matrix1, 3, 4, target12));
    assertTrue(No13MatrixPath.hasPath(matrix2, 3, 4, target21));
  }
}