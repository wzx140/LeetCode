#include "header/InsertBST.h"

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

 /**
  * 递归
  * time:O(logn)
  * space:O(logn)
  */
TreeNode* InsertBST::insertIntoBST1(TreeNode* root, int val) {
	if (NULL == root) {
		return new TreeNode(val);
	}
	if (val > root->val) {
		root->right = insertIntoBST1(root->right, val);
	}else if(val < root->val){
		root->left = insertIntoBST1(root->left, val);
	}
	return root;
}
