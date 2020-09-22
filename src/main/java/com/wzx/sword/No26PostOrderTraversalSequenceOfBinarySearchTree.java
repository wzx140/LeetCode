package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 *
 * @author wzx
 */
public class No26PostOrderTraversalSequenceOfBinarySearchTree {

  public static boolean VerifySequenceOfBST(int[] sequence) {
    if (sequence.length == 0) return false;

    return isBST(sequence, 0, sequence.length - 1);
  }

  private static boolean isBST(int[] sequence, int begin, int end) {
    if (begin >= end) return true;

    // 后跟序列 = {left_child, right_child, root}
    int root = sequence[end];
    int right = -1;
    for (int i = begin; i < end; i++) {
      // 找到左右子树的分割点
      if (right == -1 && sequence[i] > root) right = i;

      // 判断左右子树是否符合BST要求
      if (right != -1 && sequence[i] < root) return false;
      if (right == -1 && sequence[i] > root) return false;
    }

    // 未找到分割点，说明没有右子树
    right = right == -1 ? begin : right;
    return isBST(sequence, begin, right - 1)
            && isBST(sequence, right, end - 1);
  }
}
