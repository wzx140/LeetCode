#include "header/SearchBST.h"

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

 /**
  * 递归
  * time:O(logn)
  * space:O(logn)
  */
TreeNode* SearchBST::searchBST1(TreeNode * root, int val) {
	if (NULL == root) {
		return NULL;
	}
	if (root->val == val) {
		return root;
	} else if (val > root->val) {
		return searchBST1(root->right, val);
	} else {
		return searchBST1(root->left, val);
	}
}