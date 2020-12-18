package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No990SatisfiabilityOfEqualityEquationsTest {

  private final String[] e1 = {"a==b", "b!=a"};
  private final String[] e2 = {"b==a", "a==b"};
  private final String[] e3 = {"a==b", "b==c", "a==c"};
  private final String[] e4 = {"a==b", "b!=c", "c==a"};
  private final String[] e5 = {"c==c", "b==d", "x!=z"};

  @Test
  public void equationsPossible() {
    No990SatisfiabilityOfEqualityEquations solution = new No990SatisfiabilityOfEqualityEquations();
    assertFalse(solution.equationsPossible(e1));
    assertTrue(solution.equationsPossible(e2));
    assertTrue(solution.equationsPossible(e3));
    assertFalse(solution.equationsPossible(e4));
    assertTrue(solution.equationsPossible(e5));
  }
}