#include "header/PathSum.h"

/**
 * https://leetcode.com/problems/path-sum/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(height)
  */
bool PathSum::hasPathSum1(TreeNode* root, int sum) {
	if (NULL == root) {
		return false;
	} else if (sum == root->val && NULL == root->left && NULL == root->right) {
		return true;
	}

	int next = sum - root->val;
	return hasPathSum1(root->left, next) || hasPathSum1(root->right, next);
}
