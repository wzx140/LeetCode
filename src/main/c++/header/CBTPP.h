#pragma once
#include "Util.h"

#include <unordered_map>

using std::unordered_map;

class CBTPP {
public:
	TreeNode* buildTree1(vector<int>& pre, vector<int>& post);
	TreeNode* recursive(vector<int>& pre, int preStart, int preEnd, vector<int>& post, int postStart, int postEnd, unordered_map<int, int>& indexMap);
};