#include "header/ValidateBST.h"

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

 /**
  * 递归
  * time:O(logn)
  * space:O(logn)
  */
bool ValidateBST::isValidBST1(TreeNode* root) {
	return helper(root, NULL, NULL);
}

bool ValidateBST::helper(TreeNode* root, TreeNode* min, TreeNode* max) {
	if (NULL == root) {
		return true;
	}
	if (min != NULL && root->val <= min->val) {
		return false;
	}
	if (max != NULL && root->val >= max->val) {
		return false;
	}

	// 左子结点限定在(-inf,root)
	// 右子结点限定在(root,inf)
	return helper(root->left, min, root) && helper(root->right, root, max);
}
