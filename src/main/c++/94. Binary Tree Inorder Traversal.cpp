#include "header/BTIT.h"

#include <stack>

using std::stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
vector<int> BTIT::inorderTraversal1(TreeNode* root) {
	vector<int> ret;
	recursive(root, ret);
	return ret;
}

void BTIT::recursive(TreeNode* node, vector<int>& res) {
	if (node == NULL) {
		return;
	}
	recursive(node->left, res);
	res.push_back(node->val);
	recursive(node->right, res);
}


/**
 * 迭代
 * time:O(n)
 * space:O(n)
 */
vector<int> BTIT::inorderTraversal2(TreeNode* node) {
	vector<int> ret;

	stack<TreeNode*> cache;
	while (node != NULL || !cache.empty()) {
		if (node != NULL) {
			cache.push(node);
			node = node->left;
		} else {
			node = cache.top();
			cache.pop();
			ret.push_back(node->val);

			node = node->right;
		}
	}

	return ret;
}

