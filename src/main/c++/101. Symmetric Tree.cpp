#include "header/SymmetricTree.h"

/**
 * https://leetcode.com/problems/symmetric-tree/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
bool SymmetricTree::isSymmetric1(TreeNode* root) {
	if (NULL == root) {
		return true;
	}

	return recursive(root->left, root->right);
}

bool SymmetricTree::recursive(TreeNode* leftRoot, TreeNode* rightRoot) {
	if (NULL == leftRoot && NULL == rightRoot) {
		return true;
	} else if (NULL == leftRoot || NULL == rightRoot || leftRoot->val != rightRoot->val) {
		return false;
	} else {
		return recursive(leftRoot->left, rightRoot->right) && recursive(leftRoot->right, rightRoot->left);
	}
}
