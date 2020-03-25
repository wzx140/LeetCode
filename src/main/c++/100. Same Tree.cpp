#include "header/SameTree.h"

/**
 * https://leetcode.com/problems/same-tree/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
bool SameTree::isSameTree1(TreeNode* p, TreeNode* q) {
	if (NULL == p && NULL == q) {
		return true;
	} else if (NULL == p || NULL == q || p->val != q->val) {
		return false;
	} else {
		return isSameTree1(p->left, q->left) && isSameTree1(p->right, q->right);
	}
}
