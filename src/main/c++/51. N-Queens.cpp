#include "header/NQueens.h"

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
  * space:O(N)
  */
vector<vector<string>> NQueens::solveNQueens1(int n) {
	// 当前列是否有皇后
	vector<bool> cols(n, false);
	// 当前主对角线是否有皇后 row-col=constant
	vector<bool> diags(2 * n + 1,false);
	// 当前反对角线是否有皇后 row+col=constant
	vector<bool> backs(2 * n - 1, false);

	vector<string> board(n, string(n, '.'));
	vector<vector<string>> solutions;
	dfs(0, n, cols, diags, backs, board, solutions);
	return solutions;
}

/**
 * dfs+回溯
 * @param board	棋盘
 * @param solutions	解法
 * @param row	当前行
 * @param n	棋盘大小
 * @param diags	对角线状态
 * @param cols	列状态
 * @param backs	反对角线状态
 */
void NQueens::dfs(int row, int n, vector<bool>& cols, vector<bool>& diags, vector<bool>& backs, vector<string>& board, vector<vector<string>>& solutions) {

	if (row == n) {
		solutions.push_back(board);
		return;
	}

	for (int i = 0; i < n; i++) {
		if (!cols[i] && !diags[n + row - i] && !backs[row + i]) {
			// 在当前位置放置皇后
			board[row][i] = 'Q';
			cols[i] = true;
			diags[n + row - i] = true;
			backs[row + i] = true;

			dfs(row + 1, n, cols, diags, backs, board, solutions);

			// 回溯
			board[row][i] = '.';
			cols[i] = false;
			diags[n + row - i] = false;
			backs[row + i] = false;
		}
	}
}
