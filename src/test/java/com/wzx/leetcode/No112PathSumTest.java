package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No112PathSumTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1));

  @Test
  public void hasPathSum() {
    No112PathSum solution = new No112PathSum();
    assertTrue(solution.hasPathSum(tree, 22));
  }
}