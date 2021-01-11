package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a>
 * @author wzx
 */
public class No105ConstructBinaryTreeFromPreorderAndInorderTraversal {

  /**
   * 利用倒排索引加速查找
   *
   * time: O(n)
   * space: O(n)
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {

    // 中根序列的倒排索引，加速查找
    Map<Integer, Integer> InvertedIndex = new HashMap<>(inorder.length);
    for (int i = 0; i < inorder.length; i++) {
      InvertedIndex.put(inorder[i], i);
    }

    return recursion(preorder, 0, preorder.length - 1, 0, inorder.length - 1, InvertedIndex);
  }

  /**
   * preorder = {root, left, right}
   * inorder = {left, root, right}
   */
  private TreeNode recursion(int[] preorder, int preBegin, int preEnd, int InBegin, int InEnd, Map<Integer, Integer> InvertedIndex) {
    if (preBegin > preEnd) return null;

    // 由先跟序列得到root
    int rootVal = preorder[preBegin];
    TreeNode root = new TreeNode(rootVal);
    // 在中根序列中找到root
    int inRootIndex = InvertedIndex.get(rootVal);
    // 左右子树长度
    int leftNum = inRootIndex - InBegin;
    int rightNum = InEnd - inRootIndex;

    root.left = recursion(preorder, preBegin + 1, preBegin + leftNum, InBegin, inRootIndex - 1, InvertedIndex);
    root.right = recursion(preorder, preEnd - rightNum + 1, preEnd, inRootIndex + 1, InEnd, InvertedIndex);
    return root;
  }
}
