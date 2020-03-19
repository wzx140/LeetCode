#include "header/HouseRobber3.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */

 /**
 * 动态规划
 * dp[i]：打劫前i个房屋的最大收益
 * dp[i]=max(dp[i-1], dp[i-2]+nums[i])
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
int HouseRobber3::rob1(TreeNode* root) {
	unordered_map<TreeNode*, int> memo;
	return recursive(root, memo);
}

int HouseRobber3::recursive(TreeNode* root, unordered_map<TreeNode*, int>& memo) {
	if (NULL == root) {
		return 0;
	}

	auto res = memo.find(root);
	if (res != memo.end()) {
		return res->second;
	}

	// 偷
	int rob = root->val +
		// 兄弟结点间是不相邻的
		(root->left == NULL ? 0 : recursive(root->left->left, memo) + recursive(root->left->right, memo)) +
		(root->right == NULL ? 0 : recursive(root->right->left, memo) + recursive(root->right->right, memo));
	// 不偷
	int notRob = recursive(root->left, memo) + recursive(root->right, memo);

	memo[root] = max(rob, notRob);
	return memo[root];
}
