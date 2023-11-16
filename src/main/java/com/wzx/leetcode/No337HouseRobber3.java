package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/house-robber-iii/">https://leetcode.com/problems/house-robber-iii/</a>
 * @author wzx
 */
public class No337HouseRobber3 {

  /**
   * 深搜+备忘录
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int rob1(TreeNode root) {
    return recursion1(root, new HashMap<>());
  }

  private int recursion1(TreeNode root, Map<TreeNode, Integer> memo) {
    if (root == null) return 0;
    if (memo.containsKey(root)) return memo.get(root);

    int rob = root.val;
    if (root.left != null) {
      rob += recursion1(root.left.left, memo) + recursion1(root.left.right, memo);
    }
    if (root.right != null) {
      rob += recursion1(root.right.left, memo) + recursion1(root.right.right, memo);
    }
    int nRob = recursion1(root.left, memo) + recursion1(root.right, memo);
    int maxRob = Math.max(rob, nRob);

    memo.put(root, maxRob);
    return Math.max(rob, nRob);
  }

  /**
   * 递归的动态规划, 递归栈维护动态规划的迭代顺序
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public int rob2(TreeNode root) {
    int[] rob = recursion2(root);
    return Math.max(rob[0], rob[1]);
  }

  /**
   * res[0] 被偷最大金额
   * res[1] 不被偷最大金额
   */
  public int[] recursion2(TreeNode root) {
    if (root == null) return new int[]{0, 0};
    int[] robLeft = recursion2(root.left);
    int[] robRight = recursion2(root.right);

    int rob = root.val + robLeft[1] + robRight[1];
    int nRob = Math.max(robLeft[0], robLeft[1])
            + Math.max(robRight[0], robRight[1]);

    return new int[]{rob, nRob};
  }
}
