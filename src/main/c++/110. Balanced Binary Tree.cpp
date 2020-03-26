#include "header/BalancedBinaryTree.h"

#include <algorithm>

using std::max;
using std::abs;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(height)
  */
bool BalancedBinaryTree::isBalanced1(TreeNode* root) {
	if (NULL == root) {
		return true;
	}

	return checkHeight(root) == -1 ? false : true;
}

int BalancedBinaryTree::checkHeight(TreeNode* root) {
	if (NULL == root) {
		return 0;
	}
	int left = checkHeight(root->left);
	if (left == -1) {
		return -1;
	}
	int right = checkHeight(root->right);
	if (right == -1) {
		return -1;
	}
	if (abs(left - right) > 1) {
		return -1;
	}
	return max(left, right) + 1;
}
