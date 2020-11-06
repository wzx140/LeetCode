package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No39MoreThanHalfOfTheOccurrencesTest {

  private int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};

  @Test
  public void majorityElement1() {
    No39MoreThanHalfOfTheOccurrences solution = new No39MoreThanHalfOfTheOccurrences();
    assertEquals(2, solution.majorityElement1(array));
  }

  @Test
  public void majorityElement2() {
    No39MoreThanHalfOfTheOccurrences solution = new No39MoreThanHalfOfTheOccurrences();
    assertEquals(2, solution.majorityElement2(array));
  }

  @Test
  public void majorityElement3() {
    No39MoreThanHalfOfTheOccurrences solution = new No39MoreThanHalfOfTheOccurrences();
    assertEquals(2, solution.majorityElement3(array));
  }
}