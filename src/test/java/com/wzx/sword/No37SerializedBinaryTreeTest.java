package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No37SerializedBinaryTreeTest {

  TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, 2, 3, null, 4, 5));
  TreeNode tree2 = TreeNode.buildTree(Arrays.asList(5, 4, null, 3, null, 2));

  @Test
  public void serialized1() {
    No37SerializedBinaryTree solution = new No37SerializedBinaryTree();
    No37SerializedBinaryTree.Codec1 codec = solution.new Codec1();
    assertEquals(tree1, codec.deserialize(codec.serialize(tree1)));
    assertEquals(tree2, codec.deserialize(codec.serialize(tree2)));
  }

  @Test
  public void serialized2() {
    No37SerializedBinaryTree solution = new No37SerializedBinaryTree();
    No37SerializedBinaryTree.Codec2 codec = solution.new Codec2();
    assertEquals(tree1, codec.deserialize(codec.serialize(tree1)));
    assertEquals(tree2, codec.deserialize(codec.serialize(tree2)));
  }

  @Test
  public void serialized3() {
    No37SerializedBinaryTree solution = new No37SerializedBinaryTree();
    No37SerializedBinaryTree.Codec3 codec = solution.new Codec3();
    assertEquals(tree1, codec.deserialize(codec.serialize(tree1)));
    assertEquals(tree2, codec.deserialize(codec.serialize(tree2)));
  }
}