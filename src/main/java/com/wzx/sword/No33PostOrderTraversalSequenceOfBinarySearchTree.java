package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/">https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/</a>
 */
public class No33PostOrderTraversalSequenceOfBinarySearchTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public boolean verifyPostorder(int[] postorder) {
    if (postorder.length == 0) return true;

    return recursion(postorder, 0, postorder.length - 1);
  }

  private boolean recursion(int[] post, int begin, int end) {
    if (begin >= end) return true;

    // 后跟序列 = {left_child, right_child, root}
    int root = post[end];
    // 找到左右子树分割点
    int rightSplit;
    for (rightSplit = begin; rightSplit <= end; rightSplit++) {
      if (post[rightSplit] > root) break;
    }
    // 未找到分割点, 没有右子树
    if (rightSplit > end) return recursion(post, begin, end - 1);
    // 判断右子树合法性
    for (int i = rightSplit; i < end; i++) {
      if (post[i] <= root) return false;
    }
    return recursion(post, begin, rightSplit - 1) && recursion(post, rightSplit, end - 1);
  }
}
