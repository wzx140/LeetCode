package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/">https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/</a>
 * @author wzx
 */
public class No889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    // 后跟序列的倒排索引，加速查找
    Map<Integer, Integer> invertedIndex = new HashMap<>(pre.length);
    for (int i = 0; i < post.length; i++) {
      invertedIndex.put(post[i], i);
    }

    return recursion(pre, 0, pre.length - 1, 0, pre.length - 1, invertedIndex);
  }

  /**
   * 先根序列 = {root, left, right}, left中的首个元素为root的左子结点, right中的首个元素为root的右子结点
   * 后根序列 = {left, right, root}, left中的末尾元素为root的左子结点, right中的末尾元素为root的右子结点
   */
  private TreeNode recursion(int[] pre, int preBegin, int preEnd, int postBegin, int postEnd, Map<Integer, Integer> invertedIndex) {
    if (preBegin > preEnd) return null;
    if (preBegin == preEnd) return new TreeNode(pre[preBegin]);

    // 在先根序列中找到root和其左子结点，默认左子树优先存在
    int rootVal = pre[preBegin];
    TreeNode root = new TreeNode(rootVal);
    int leftVal = pre[preBegin + 1];
    // 在后根序列中找到root左子结点
    int postLeftIndex = invertedIndex.get(leftVal);
    // 左右子树长度
    int leftNum = postLeftIndex - postBegin + 1;
    int rightNum = postEnd - 1 - postBegin + 1 - leftNum;

    root.left = recursion(pre, preBegin + 1, preBegin + leftNum, postBegin, postBegin + leftNum - 1, invertedIndex);
    root.right = recursion(pre, preEnd - rightNum + 1, preEnd, postEnd - rightNum, postEnd - 1, invertedIndex);
    return root;
  }
}
