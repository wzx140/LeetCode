package com.wzx.leetcode;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No310MinimumHeightTreesTest {

  private final int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
  private final List<Integer> res1 = Collections.singletonList(1);
  private final int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
  private final List<Integer> res2 = Arrays.asList(3, 4);
  private final int[][] edges3 = {{0, 1}};
  private final List<Integer> res3 = Arrays.asList(0, 1);

  @Test
  public void findMinHeightTrees1() {
    No310MinimumHeightTrees solution = new No310MinimumHeightTrees();
    Assert.assertEquals(res1, solution.findMinHeightTrees1(4, edges1));
    Assert.assertEquals(res2, solution.findMinHeightTrees1(6, edges2));
    Assert.assertEquals(res3, solution.findMinHeightTrees1(2, edges3));
    Assert.assertEquals(Collections.singletonList(0), solution.findMinHeightTrees1(1, new int[0][0]));
  }

  @Test
  public void findMinHeightTrees2() {
    No310MinimumHeightTrees solution = new No310MinimumHeightTrees();
    Assert.assertEquals(res1, solution.findMinHeightTrees2(4, edges1));
    Assert.assertEquals(res2, solution.findMinHeightTrees2(6, edges2));
    Assert.assertEquals(res3, solution.findMinHeightTrees2(2, edges3));
    Assert.assertEquals(Collections.singletonList(0), solution.findMinHeightTrees2(1, new int[0][0]));
  }
}