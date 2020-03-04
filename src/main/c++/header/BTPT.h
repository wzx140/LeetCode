#pragma once
#include <vector>
#include <iostream>
#include "Util.h"

using std::vector;

class BTPT {
public:
	vector<int> preorderTraversal1(TreeNode* root);
	void recursive(TreeNode* node, vector<int>& res);
	vector<int> preorderTraversal2(TreeNode* root);
};