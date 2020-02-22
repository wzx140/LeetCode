#pragma once
#include <vector>

using std::vector;

class Permutations2 {
public:
	vector<vector<int>> permuteUnique1(vector<int>& nums);
	void dfs1(vector<int>& nums, vector<bool>& used, vector<vector<int>>& perms, vector<int>& perm);
};
