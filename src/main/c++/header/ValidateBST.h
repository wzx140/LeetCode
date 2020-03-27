#pragma once
#include "Util.h"

class ValidateBST {
public:
	bool isValidBST1(TreeNode* root);
	bool helper(TreeNode* root, TreeNode* min, TreeNode* max);
};