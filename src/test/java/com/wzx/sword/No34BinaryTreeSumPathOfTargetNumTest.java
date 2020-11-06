package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class No34BinaryTreeSumPathOfTargetNumTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(1, 2, 4, 5, 3, 4, 3));
  private final ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

  {
    paths.add(new ArrayList<>(Arrays.asList(1, 2, 5)));
    paths.add(new ArrayList<>(Arrays.asList(1, 4, 3)));
  }

  @Test
  public void pathSum() {
    No34BinaryTreeSumPathOfTargetNum solution = new No34BinaryTreeSumPathOfTargetNum();
    Assert.assertEquals(paths, solution.pathSum(tree, 8));
  }
}