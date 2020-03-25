#pragma once
#include "Util.h"

class SymmetricTree {
public:
	bool isSymmetric1(TreeNode* root);
	bool recursive(TreeNode* leftRoot, TreeNode* rightRoot);
};