#include "header/CBTPP.h"

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */

 /**
  * 递归
  * 先根序列={root,左子树,右子树}
  * 后根序列={左子树,右子树,root}
  * time:O(n)
  * space:O(n)
  */
TreeNode* CBTPP::buildTree1(vector<int>& pre, vector<int>& post) {
	if (pre.empty()) {
		return NULL;
	}

	// 后跟序列的倒排索引
	unordered_map<int, int> indexMap;
	int len = post.size();
	for (int i = 0; i < len; i++) {
		indexMap[post[i]] = i;
	}

	return recursive(pre, 0, len - 1, post, 0, len - 1, indexMap);
}

TreeNode* CBTPP::recursive(vector<int>& pre, int preStart, int preEnd, vector<int>& post, int postStart, int postEnd, unordered_map<int, int>& indexMap) {

	TreeNode* root = new TreeNode(pre[preStart]);

	// 左右子树都为空
	if (preStart == preEnd) {
		root->left = NULL;
		root->right = NULL;
		return root;
	}

	int leftRootOfPre = preStart + 1;
	int leftRootVal = pre[leftRootOfPre];
	int rightRootOfPost = indexMap[leftRootVal] + 1;

	// 重建左子树
	root->left = recursive(pre, preStart + 1, preStart + 1 + rightRootOfPost - 1 - postStart, post, postStart, rightRootOfPost - 1, indexMap);

	// 重建右子树
	if (rightRootOfPost != postEnd) {
		root->right = recursive(pre, preEnd - (postEnd - 1 - rightRootOfPost), preEnd, post, rightRootOfPost, postEnd - 1, indexMap);
	} else {
		root->right = NULL;
	}

	return root;
}
