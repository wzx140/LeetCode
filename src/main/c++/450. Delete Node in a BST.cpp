#include "header/DeleteBST.h"

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */

 /**
  * 递归
  * time:O(logn)
  * space:O(logn)
  */
TreeNode* DeleteBST::deleteNode1(TreeNode* root, int key) {
	if (NULL == root) {
		return NULL;
	}

	if (key > root->val) {
		root->right = deleteNode1(root->right, key);
	} else if (key < root->val) {
		root->left = deleteNode1(root->left, key);
	} else {
		// 找到目标结点
		if (NULL == root->left) {
			// 左子结点为空
			root = root->right;
		}else if(NULL == root->right){
			// 右子结点为空
			root = root->left;
		} else {
			// 替换为左子树中最大的结点
			int repVal = findMax(root->left);
			root->val = repVal;
			// 删除替换后的root结点
			root->left = deleteNode1(root->left, repVal);
		}
	}

	return root;
}

int DeleteBST::findMax(TreeNode* root) {
	while (root->right != NULL) {
		root = root->right;
	}
	return root->val;
}
