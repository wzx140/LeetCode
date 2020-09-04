package com.wzx.entity;

/**
 * 二叉树数据结构
 *
 * @author wzx
 */
public class TreeNode {
  public int val;
  public TreeNode left = null;
  public TreeNode right = null;
  public TreeNode parent = null;

  public TreeNode(int val){
    this.val = val;
  }
}
