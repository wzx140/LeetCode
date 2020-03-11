#include "header/CBTIP.h"

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

 /**
  * 递归
  * 中根序列={左子树,root,右子树}
  * 后根序列={左子树,右子树,root}
  * time:O(n)
  * space:O(n)
  */
TreeNode* CBTIP::buildTree1(vector<int>& inorder, vector<int>& postorder) {
	if(inorder.empty()){
		return NULL;
	}

	// 建立中根序列的倒排索引
	unordered_map<int, int> indexMap;
	int len = inorder.size();
	for (int i = 0; i < len; i++) {
		indexMap[inorder[i]] = i;
	}
	return recursive(inorder, 0, len - 1, postorder, 0, len - 1, indexMap);
}

TreeNode* CBTIP::recursive(vector<int>& inorder, int inStart, int inEnd, vector<int>& postorder, int postStart, int postEnd, unordered_map<int, int>& indexMap) {

	TreeNode* root = new TreeNode(postorder[postEnd]);
	int inSplit = indexMap[root->val];

	// 重建左子树
	if (inSplit == inStart) {
		root->left = NULL;
	} else {
		root->left = recursive(inorder, inStart, inSplit - 1, postorder, postStart, postStart + (inSplit - 1 - inStart), indexMap);
	}

	// 重建右子树
	if (inSplit == inEnd) {
		root->right = NULL;
	} else {
		root->right = recursive(inorder, inSplit + 1, inEnd, postorder, postEnd - 1 - (inEnd - inSplit - 1), postEnd - 1, indexMap);
	}

	return root;
}
