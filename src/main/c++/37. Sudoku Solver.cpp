#include "header/SudokuSolver.h"

#include <vector>
#include <bitset>
#include <array>

using std::vector;
using std::bitset;
using std::pair;
using std::array;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */

/**
 * dfs+回溯
 * @param board	棋盘
 * @param spaces	棋盘空格
 * @param pos	当前空格位置
 * @param rows	行状态(每一行中填入了那些数字)
 * @param cols	列状态
 * @param boxs	box状态
 */
bool solve(vector<vector<char>>& board, const vector<array<int, 2>>& spaces, int pos, bitset<9> rows[9], bitset<9> cols[9], bitset<9> boxs[9]) {
	if (pos >= spaces.size()) {
		return true;
	}

	int x = spaces[pos][0];
	int y = spaces[pos][1];

	for (int value = 0; value < 9; value++) {
		// 行列box，有一种条件不满足，则不是合法的填法
		if (rows[x][value] || cols[value][y] || boxs[x / 3 * 3 + y / 3][value]) {
			continue;
		} else {
			rows[x][value] = true;
			cols[value][y] = true;
			boxs[x / 3 * 3 + y / 3][value] = true;
			board[x][y] = value + 1 + '0';

			if(solve(board, spaces, pos + 1, rows, cols, boxs)){
				return true;
			}

			// 回溯
			rows[x][value] = false;
			cols[value][y] = false;
			boxs[x / 3 * 3 + y / 3][value] = false;
			board[x][y] = '.';
		}
	}
	return false;
}

/**
 * 想想八皇后问题，dfs+回溯
 * time:O(n)
 * space:O(n)
 */
void SudokuSolver::solveSudoku1(vector<vector<char>>& board) {
	// 记录每一行，列，box的数字填充情况
	bitset<9> rows[9];
	bitset<9> cols[9];
	bitset<9> boxs[9];
	// 空格
	vector<array<int, 2>> spaces;

	// 初始化数字填充情况
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				int value = board[i][j] - '0' - 1;
				rows[i][value] = true;
				cols[value][j] = true;
				boxs[i / 3 * 3 + j / 3][value] = true;
			} else {
				spaces.push_back({ i,j });
			}
		}
	}

	solve(board, spaces, 0, rows, cols, boxs);
}
