package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No222CountCompleteTreeNodesTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6));

  @Test
  public void countNodes1() {
    No222CountCompleteTreeNodes solution = new No222CountCompleteTreeNodes();
    assertEquals(6, solution.countNodes1(tree));
  }

  @Test
  public void countNodes2() {
    No222CountCompleteTreeNodes solution = new No222CountCompleteTreeNodes();
    assertEquals(6, solution.countNodes2(tree));
  }

  @Test
  public void countNodes3() {
    No222CountCompleteTreeNodes solution = new No222CountCompleteTreeNodes();
    assertEquals(6, solution.countNodes3(tree));
  }
}