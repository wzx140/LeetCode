#pragma once
#include <vector>

using std::vector;

class NQueens2 {
public:
	int totalNQueens1(int n);
	void dfs(int row, int n, vector<bool>& cols, vector<bool>& diags, vector<bool>& backs, int& solution);
};
