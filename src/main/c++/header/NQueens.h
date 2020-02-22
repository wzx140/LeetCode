#pragma once
#include <vector>
#include <string>

using std::vector;
using std::string;

class NQueens {
public:
	vector<vector<string>> solveNQueens1(int n);
	void dfs(int row, int n, vector<bool>& cols, vector<bool>& diags, vector<bool>& backs, vector<string>& board, vector<vector<string>>& solutions);
};
