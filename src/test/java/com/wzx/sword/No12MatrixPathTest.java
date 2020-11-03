package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No12MatrixPathTest {

  private final char[][] matrix1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
  private final String word1 = "ABCCED";

  private final char[][] matrix2 = {{'a','b'},{'c','d'}};
  private final String word2 = "abcd";


  @Test
  public void exist() {
    No12MatrixPath solution = new No12MatrixPath();
    assertTrue(solution.exist(matrix1, word1));
    assertFalse(solution.exist(matrix2, word2));
  }
}