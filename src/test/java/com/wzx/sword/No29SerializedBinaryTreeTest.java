package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No29SerializedBinaryTreeTest {

  TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, 2, 3, null, 4, 5));
  TreeNode tree2 = TreeNode.buildTree(Arrays.asList(5, 4, null, 3, null, 2));

  @Test
  public void serialized1() {
    No29SerializedBinaryTree solution = new No29SerializedBinaryTree();
    assertTrue(TreeNode.treeEquals(tree1, solution.Deserialize1(solution.Serialize1(tree1))));
    assertTrue(TreeNode.treeEquals(tree2, solution.Deserialize1(solution.Serialize1(tree2))));
  }

  @Test
  public void serialized2() {
    No29SerializedBinaryTree solution = new No29SerializedBinaryTree();
    assertTrue(TreeNode.treeEquals(tree1, solution.Deserialize2(solution.Serialize2(tree1))));
    assertTrue(TreeNode.treeEquals(tree2, solution.Deserialize2(solution.Serialize2(tree2))));
  }


  @Test
  public void serialized3() {
    No29SerializedBinaryTree solution = new No29SerializedBinaryTree();
    assertTrue(TreeNode.treeEquals(tree1, solution.Deserialize3(solution.Serialize31(tree1))));
    assertTrue(TreeNode.treeEquals(tree2, solution.Deserialize3(solution.Serialize31(tree2))));
  }
}