#pragma once
#include "Util.h"

#include <unordered_map>

using std::unordered_map;

class HouseRobber3 {
public:
	int rob1(TreeNode* root);
	int recursive(TreeNode* root, unordered_map<TreeNode*, int>& memo);
};