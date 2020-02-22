#pragma once
#include <vector>

using std::vector;

class CombinationSum {
public:
	vector<vector<int>> combinationSum1(vector<int>& candidates, int target);
	void dfs(const vector<int>& candidates, int target, int start, vector<int>& solution, vector<vector<int>>& res);
};
