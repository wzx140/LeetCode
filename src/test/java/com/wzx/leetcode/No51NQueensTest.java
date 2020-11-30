package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class No51NQueensTest {

  private final List<List<String>> res1 = Arrays.asList(
          Arrays.asList(
                  ".Q..",
                  "...Q",
                  "Q...",
                  "..Q."),
          Arrays.asList(
                  "..Q.",
                  "Q...",
                  "...Q",
                  ".Q..")
  );

  private final List<List<String>> res2 = Collections.singletonList(Collections.singletonList("Q"));

  @Test
  public void solveNQueens() {
    No51NQueens solution = new No51NQueens();

    List<List<String>> ret1 = solution.solveNQueens(4);
    assertTrue(ret1.containsAll(res1));
    assertTrue(res1.containsAll(ret1));

    List<List<String>> ret2 = solution.solveNQueens(1);
    assertTrue(ret2.containsAll(res2));
    assertTrue(res2.containsAll(ret2));
  }
}