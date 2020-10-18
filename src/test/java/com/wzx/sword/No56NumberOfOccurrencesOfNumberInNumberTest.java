package com.wzx.sword;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class No56NumberOfOccurrencesOfNumberInNumberTest {

  private final int[] nums1 = {4, 1, 4, 6};
  private final int[] nums2 = {1, 2, 10, 4, 1, 4, 3, 3};

  @Test
  public void singleNumbers1() {
    No56NumberOfOccurrencesOfNumberInNumber solution = new No56NumberOfOccurrencesOfNumberInNumber();
    MatcherAssert.<int[]>assertThat(solution.singleNumbers1(nums1),
            Matchers.either(Matchers.is(new int[]{1, 6})).or(Matchers.is(new int[]{6, 1})));
    MatcherAssert.<int[]>assertThat(solution.singleNumbers1(nums2),
            Matchers.either(Matchers.is(new int[]{2, 10})).or(Matchers.is(new int[]{10, 2})));
  }

  @Test
  public void singleNumbers2() {
    No56NumberOfOccurrencesOfNumberInNumber solution = new No56NumberOfOccurrencesOfNumberInNumber();
    MatcherAssert.<int[]>assertThat(solution.singleNumbers2(nums1),
            Matchers.either(Matchers.is(new int[]{1, 6})).or(Matchers.is(new int[]{6, 1})));
    MatcherAssert.<int[]>assertThat(solution.singleNumbers2(nums2),
            Matchers.either(Matchers.is(new int[]{2, 10})).or(Matchers.is(new int[]{10, 2})));
  }
}