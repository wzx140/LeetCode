#include "header/MinDBT.h"

#include <algorithm>

using std::min;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
int MinDBT::minDepth1(TreeNode* root) {
	if (NULL == root) {
		return 0;
	}

	// 递归直到左右子结点都为null
	if (root->left && root->right) {
		return min(minDepth1(root->left), minDepth1(root->right)) + 1;
	}else if (root->left) {
		return minDepth1(root->left) + 1;
	}else if (root->right) {
		return minDepth1(root->right) + 1;
	} else {
		return 1;
	}
}
