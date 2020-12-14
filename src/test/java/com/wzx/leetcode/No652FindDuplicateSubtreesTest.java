package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class No652FindDuplicateSubtreesTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, null, 2, 4, null, null, 4));
  private final List<TreeNode> res1 = Arrays.asList(TreeNode.buildTree(Arrays.asList(2, 4)), TreeNode.buildTree(Collections.singletonList(4)));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(2, 1, 1));
  private final List<TreeNode> res2 = Collections.singletonList(TreeNode.buildTree(Collections.singletonList(1)));
  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(2, 2, 2, 3, null, 3));
  private final List<TreeNode> res3 = Arrays.asList(TreeNode.buildTree(Arrays.asList(2, 3)), TreeNode.buildTree(Collections.singletonList(3)));

  @Test
  public void findDuplicateSubtrees() {
    No652FindDuplicateSubtrees solution = new No652FindDuplicateSubtrees();
    List<TreeNode> ret1 = solution.findDuplicateSubtrees(tree1);
    assertTrue(res1.containsAll(ret1));
    assertTrue(ret1.containsAll(res1));
    List<TreeNode> ret2 = solution.findDuplicateSubtrees(tree2);
    assertTrue(res2.containsAll(ret2));
    assertTrue(ret2.containsAll(res2));
    List<TreeNode> ret3 = solution.findDuplicateSubtrees(tree3);
    assertTrue(res3.containsAll(ret3));
    assertTrue(ret3.containsAll(res3));
  }
}