package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class No113PathSum2Test {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
  private final List<List<Integer>> res = Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5));

  @Test
  public void pathSum1() {
    No113PathSum2 solution = new No113PathSum2();
    assertEquals(res, solution.pathSum(tree, 22));
  }
}