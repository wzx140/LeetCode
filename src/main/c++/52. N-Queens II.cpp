#include "Header.h"

#include <vector>
#include <string>

using std::vector;
using std::string;

/**
 * https://leetcode.com/problems/n-queens/
 */

 /**
  *
  * time:O(N!),N为解法个数
  * space:O(n)
  */
int NQueens2::totalNQueens1(int n) {
	// 当前列是否有皇后
	vector<bool> cols(n, false);
	// 当前主对角线是否有皇后 row-col=constant
	vector<bool> diags(2 * n + 1, false);
	// 当前反对角线是否有皇后 row+col=constant
	vector<bool> backs(2 * n - 1, false);

	vector<string> board(n, string(n, '.'));
	vector<vector<string>> solutions;
	int solution = 0;
	dfs(0, n, cols, diags, backs, solution);
	return solution;
}

/**
 * dfs+回溯
 * @param row	当前行
 * @param n	棋盘大小
 * @param diags	对角线状态
 * @param cols	列状态
 * @param backs	反对角线状态
 * @param solution	解法个数
 */
void NQueens2::dfs(int row, int n, vector<bool>& cols, vector<bool>& diags, vector<bool>& backs, int& solution) {

	if (row == n) {
		solution++;
		return;
	}

	for (int i = 0; i < n; i++) {
		if (!cols[i] && !diags[n + row - i] && !backs[row + i]) {
			// 在当前位置放置皇后
			cols[i] = true;
			diags[n + row - i] = true;
			backs[row + i] = true;

			dfs(row + 1, n, cols, diags, backs, solution);

			// 回溯
			cols[i] = false;
			diags[n + row - i] = false;
			backs[row + i] = false;
		}
	}
}
