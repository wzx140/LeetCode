package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * @author wzx
 */
public class No652FindDuplicateSubtrees {

  /**
   * 将子树序列化, 通过哈希表比较
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Boolean> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    recursion(root, memo, res);
    return res;
  }

  private String recursion(TreeNode node, Map<String, Boolean> memo, List<TreeNode> res) {
    // 序列化
    if (node == null) return "#";
    String left = recursion(node.left, memo, res);
    String right = recursion(node.right, memo, res);
    String serialization = left + "," + right + "," + node.val;

    // 未出现
    if (!memo.containsKey(serialization)) {
      memo.put(serialization, false);
    }
    // 只重复了一次
    else if (!memo.get(serialization)) {
      res.add(node);
      memo.put(serialization, true);
    }

    return serialization;
  }
}
