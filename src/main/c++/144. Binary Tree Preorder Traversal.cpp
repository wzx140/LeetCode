#include "header/BTPT.h";

#include <stack>

using std::stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
vector<int> BTPT::preorderTraversal1(TreeNode* root) {
	vector<int> res;
	recursive(root, res);
	return res;
}

void BTPT::recursive(TreeNode* node, vector<int>& res) {
	if (node == NULL) {
		return;
	}
	res.push_back(node->val);
	recursive(node->left, res);
	recursive(node->right, res);
}


/**
 * 非递归
 * https://masterwangzx.com/2019/03/16/binary-tree/#%E9%9D%9E%E9%80%92%E5%BD%92%E5%AE%9E%E7%8E%B0
 * time:O(n)
 * space:O(n)
 */
vector<int> BTPT::preorderTraversal2(TreeNode* root) {
	vector<int> res;
	// cache起到缓存右子树的作用
	stack<TreeNode*> cache;
	cache.push(NULL);

	while (root != NULL) {
		res.push_back(root->val);

		if (root->right != NULL) {
			cache.push(root->right);
		}

		if (root->left != NULL) {
			root = root->left;
		} else {
			root = cache.top();
			cache.pop();
		}
	}

	return res;
}