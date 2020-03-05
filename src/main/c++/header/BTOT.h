#pragma once
#include "Util.h"

class BTOT {
public:
	vector<int> postorderTraversal1(TreeNode* root);
	void recursion(TreeNode* node, vector<int>& res);
	vector<int> postorderTraversal2(TreeNode* root);
};
