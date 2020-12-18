package com.wzx.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class No130SurroundedRegionsTest {

  private char[][] board = null;
  private final char[][] res = {
          {'X', 'X', 'X', 'X'},
          {'X', 'X', 'X', 'X'},
          {'X', 'X', 'X', 'X'},
          {'X', 'O', 'X', 'X'}
  };

  @Before
  public void setUp() {
    board = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
    };
  }

  @Test
  public void solve1() {
    No130SurroundedRegions solution = new No130SurroundedRegions();
    solution.solve1(board);
    assertArrayEquals(board, res);
  }

  @Test
  public void solve2() {
    No130SurroundedRegions solution = new No130SurroundedRegions();
    solution.solve2(board);
    assertArrayEquals(board, res);
  }
}