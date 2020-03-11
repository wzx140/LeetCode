#pragma once
#pragma once
#include "Util.h"

#include <unordered_map>

using std::unordered_map;

class CBTIP {
public:
	TreeNode* buildTree1(vector<int>& inorder, vector<int>& postorder);
	TreeNode* recursive(vector<int>& inorder, int inStart, int inEnd, vector<int>& postorder, int postStart, int postEnd, unordered_map<int, int>& indexMap);
};