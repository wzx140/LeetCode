package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/">https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/</a>
 */
public class No32PrintTheBinaryTreeFromTopToBottom3 {

  /**
   * 队列
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new LinkedList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    queue.addLast(root);

    while (!queue.isEmpty()) {
      int layerSize = res.size();
      int queueSize = queue.size();
      LinkedList<Integer> layer = new LinkedList<>();
      for (int i = 0; i < queueSize; i++) {
        TreeNode node = queue.pollFirst();
        // 当前层根据层数判断是否逆序
        if ((layerSize & 1) == 0) {
          layer.addLast(node.val);
        } else {
          layer.addFirst(node.val);
        }
        // 下一层
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      if (!layer.isEmpty()) res.add(layer);
    }

    return res;
  }
}
