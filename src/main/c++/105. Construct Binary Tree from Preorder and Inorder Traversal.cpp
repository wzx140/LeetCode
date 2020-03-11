#include "header/CBTPI.h"

#include <algorithm>
#include <stack>

using std::find;
using std::stack;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

 /**
  * 递归
  * 先根序列={root,左子树,右子树}
  * 中根序列={左子树,root,右子树}
  * time:O(n)
  * space:O(n)
  */
TreeNode* CBTPI::buildTree1(vector<int>& preorder, vector<int>& inorder) {
	if (preorder.empty()) {
		return NULL;
	}

	// 中序遍历的倒排索引
	unordered_map<int, int> indexMap;
	int len = inorder.size();
	for (int i = 0; i < len; i++) {
		indexMap[inorder[i]] = i;
	}

	return recursive(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, indexMap);
}

TreeNode* CBTPI::recursive(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd, unordered_map<int, int>& indexMap) {
	TreeNode* root = new TreeNode(preorder[preStart]);
	// 中根序列的root位置
	int inSplit = indexMap[preorder[preStart]];

	// 重建左子树
	if (inSplit == inStart) {
		root->left = NULL;
	} else {
		root->left = recursive(preorder, preStart + 1, preStart + 1 + (inSplit - 1 - inStart), inorder, inStart, inSplit - 1, indexMap);
	}

	// 重建右子树
	if (inSplit == inEnd) {
		root->right = NULL;
	} else {
		root->right = recursive(preorder, preEnd - (inEnd - inSplit) + 1, preEnd, inorder, inSplit + 1, inEnd, indexMap);
	}

	return root;
}