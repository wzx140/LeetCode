#pragma once
#include <vector>

using std::vector;

class Permutations {
public:
	vector<vector<int>> permute1(vector<int>& nums);
	void dfs1(vector<int>& nums, vector<int>& indexes, vector<vector<int>>& perms, vector<int>& perm);
	vector<vector<int>> permute2(vector<int>& nums);
	void dfs2(vector<int>& nums, int first, int n, vector<vector<int>>& perms);
};
