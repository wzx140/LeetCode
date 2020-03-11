#pragma once
#include "Util.h"

#include <unordered_map>

using std::unordered_map;

class CBTPI {
public:
	TreeNode* buildTree1(vector<int>& preorder, vector<int>& inorder);
	TreeNode* recursive(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd, unordered_map<int, int>& indexMap);
};