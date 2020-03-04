#pragma once
#include "Util.h"

class BTIT {
public:
	vector<int> inorderTraversal1(TreeNode* root);
	void recursive(TreeNode* node, vector<int>& res);
	vector<int> inorderTraversal2(TreeNode* root);
};