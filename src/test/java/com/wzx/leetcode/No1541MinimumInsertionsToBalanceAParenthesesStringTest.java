package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No1541MinimumInsertionsToBalanceAParenthesesStringTest {

  @Test
  public void minInsertions() {
    No1541MinimumInsertionsToBalanceAParenthesesString solution = new No1541MinimumInsertionsToBalanceAParenthesesString();
    assertEquals(1,solution.minInsertions("(()))"));
    assertEquals(0,solution.minInsertions("())"));
    assertEquals(3,solution.minInsertions("))())("));
    assertEquals(12,solution.minInsertions("(((((("));
    assertEquals(5,solution.minInsertions(")))))))"));
    assertEquals(4,solution.minInsertions("(()))(()))()())))"));
  }
}