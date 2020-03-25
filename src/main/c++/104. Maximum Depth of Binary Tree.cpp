#include "header/MDBT.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
int MDBT::maxDepth1(TreeNode* root) {
	if (NULL == root) {
		return 0;
	}

	return max(maxDepth1(root->left), maxDepth1(root->right)) + 1;
}
