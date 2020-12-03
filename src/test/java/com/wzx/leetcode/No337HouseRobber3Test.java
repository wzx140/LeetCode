package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class No337HouseRobber3Test {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 2, 3, null, 3, null, 1));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(3, 4, 5, 1, 3, null, 1));

  @Test
  public void rob1() {
    No337HouseRobber3 solution = new No337HouseRobber3();
    Assert.assertEquals(7, solution.rob1(tree1));
    Assert.assertEquals(9, solution.rob1(tree2));
  }

  @Test
  public void rob2() {
    No337HouseRobber3 solution = new No337HouseRobber3();
    Assert.assertEquals(7, solution.rob2(tree1));
    Assert.assertEquals(9, solution.rob2(tree2));
  }
}