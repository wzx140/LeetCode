#include "header/BTOT.h"

#include <stack>
#include <map>

using std::pair;
using std::stack;
using std::make_pair;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

 /**
  * 递归
  * time:O(n)
  * space:O(n)
  */
vector<int> BTOT::postorderTraversal1(TreeNode* root) {
	vector<int> ret;
	recursion(root, ret);
	return ret;
}

void BTOT::recursion(TreeNode* node, vector<int>& res) {
	if (node == NULL) {
		return;
	}
	recursion(node->left, res);
	recursion(node->right, res);
	res.push_back(node->val);
}

/**
 * 非递归
 * time:O(n)
 * space:O(n)
 */
vector<int> BTOT::postorderTraversal2(TreeNode* root) {
	// true->从左子树返回
	// false->从右子树返回
	stack<pair<TreeNode*, bool>> cache;
	vector<int> ret;

	while (root != NULL || !cache.empty()) {
		if (root != NULL) {
			cache.push(make_pair(root, true));
			root = root->left;
		} else {
			
			if(cache.top().second){
				// 从左子树返回
				cache.top().second = false;
				root = cache.top().first->right;
			} else {
				// 从右子树返回
				ret.push_back(cache.top().first->val);
				cache.pop();
			}
		}
	}

	return ret;
}
