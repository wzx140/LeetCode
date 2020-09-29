package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No31MoreThanHalfOfTheOccurrencesTest {

  private int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};

  @Test
  public void moreThanHalfNum_Solution1() {
    No31MoreThanHalfOfTheOccurrences solution = new No31MoreThanHalfOfTheOccurrences();
    assertEquals(2, solution.MoreThanHalfNum_Solution1(array));
  }

  @Test
  public void moreThanHalfNum_Solution2() {
    No31MoreThanHalfOfTheOccurrences solution = new No31MoreThanHalfOfTheOccurrences();
    assertEquals(2, solution.MoreThanHalfNum_Solution2(array));
  }

  @Test
  public void moreThanHalfNum_Solution3() {
    No31MoreThanHalfOfTheOccurrences solution = new No31MoreThanHalfOfTheOccurrences();
    assertEquals(2, solution.MoreThanHalfNum_Solution3(array));
  }
}