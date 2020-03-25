#include "header/CCTN.h"

#include <algorithm>

using std::pow;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */

 /**
  * 一棵完全二叉树的两棵子树，至少有一棵是满二叉树
  * https://mp.weixin.qq.com/s/xW2fbE3v4JhMSKfxoxIHBg
  * time:O(logn*logn)
  * space:O(logn)
  */
int CCTN::countNodes1(TreeNode* root) {
	if (NULL == root) {
		return 0;
	}

	int lHeight = 1, rHeight = 1;
	TreeNode* lNode = root->left;
	TreeNode*	rNode = root->right;
	while (lNode != NULL) {
		lHeight++;
		lNode = lNode->left;
	}
	while (rNode != NULL) {
		rHeight++;
		rNode = rNode->right;
	}

	if (lHeight == rHeight) {
		// 满二叉树
		return pow(2, lHeight) - 1;
	} else {
		return countNodes1(root->left) + countNodes1(root->right) + 1;
	}
}
