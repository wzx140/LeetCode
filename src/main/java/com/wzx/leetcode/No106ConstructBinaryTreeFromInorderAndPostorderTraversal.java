package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author wzx
 */
public class No106ConstructBinaryTreeFromInorderAndPostorderTraversal {

  /**
   * 倒排索引，加速查找
   *
   * time: O(n)
   * space: O(n)
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {

    // 中根序列的倒排索引，加速查找
    Map<Integer, Integer> invertedIndex = new HashMap<>(inorder.length);
    for (int i = 0; i < inorder.length; i++) {
      invertedIndex.put(inorder[i], i);
    }

    return recursion(0, inorder.length - 1, postorder, 0, postorder.length - 1, invertedIndex);
  }

  /**
   * 中根序列 = {left, root, right}
   * 后跟序列 = {left, right, root}
   */
  public TreeNode recursion(int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd, Map<Integer, Integer> invertedIndex) {
    if (inBegin > inEnd) return null;

    // 由后根序列得到root
    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);
    // 中根序列中找到root
    int inRootIndex = invertedIndex.get(rootVal);
    // 左右子树长度
    int leftNum = inRootIndex - inBegin;
    int rightNum = inEnd - inRootIndex;

    root.left = recursion(inBegin, inRootIndex - 1, postorder, postBegin, postBegin + leftNum - 1, invertedIndex);
    root.right = recursion(inRootIndex + 1, inEnd, postorder, postEnd - 1 - rightNum + 1, postEnd - 1, invertedIndex);
    return root;
  }
}
