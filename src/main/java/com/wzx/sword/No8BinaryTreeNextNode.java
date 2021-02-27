package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e">https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e</a>
 */
public class No8BinaryTreeNextNode {

  /**
   * |     0
   * |  1     2
   * |3  4   5  6
   * <p>
   * 3 1 4 0 5 2 6
   * <p>
   * 中序遍历的逆推
   * 1. 有右子树，返回右子树中最左结点
   * 2. 没有右子树，找到是左子结点的祖先结点，返回父结点
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public TreeLinkNode GetNext(TreeLinkNode pNode) {
    if (null == pNode) return null;

    TreeLinkNode node;
    if (pNode.right != null) {
      node = pNode.right;
      while (node.left != null) node = node.left;
    } else {
      node = pNode;
      while (node.next != null && node.next.left != node) node = node.next;
      node = node.next;
    }

    return node;
  }


  public static class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
      this.val = val;
    }
  }
}
