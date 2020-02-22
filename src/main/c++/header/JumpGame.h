#pragma once
#include <vector>

using std::vector;

class JumpGame {
public:
	bool canJump1(vector<int>& nums);
	bool dfs(vector<int>& nums, vector<int>& jumped, int pos, int len);
	bool canJump2(vector<int>& nums);
	bool canJump3(vector<int>& nums);
};
