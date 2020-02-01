#include "Header.H"

#include <unordered_set>
#include <vector>

using std::unordered_set;
using std::vector;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */

/**
 * 用哈希表判断是否出现重复
 * time:O(n)
 * space:O(n)
 *
 */
bool ValidSudoku::isValidSudoku1(vector<vector<char>>& board) {
	for (int i = 0; i < 9; i++) {
		unordered_set<char> rows;
		unordered_set<char> cols;
		unordered_set<char> boxs;

		for (int j = 0; j < 9; j++) {
			// 检查行
			if (board[i][j] != '.') {
				if (rows.find(board[i][j]) != rows.end()) {
					return false;
				} else {
					rows.insert(board[i][j]);
				}
			}
			// 检查列
			if (board[j][i] != '.') {
				if (cols.find(board[j][i]) != cols.end()) {
					return false;
				} else {
					cols.insert(board[j][i]);
				}
			}
			// 检查box
			// 注意索引的规律
			if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.') {
				if (boxs.find(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]) != boxs.end()) {
					return false;
				} else {
					boxs.insert(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]);
				}
			}
		}

	}

	return true;
}

/**
 * 注意到元素只能是1~9，可以为每个集合(row,col,box)中的每个1~9设置标志位
 * time:O(n)
 * space:O(n)
 *
 */
bool ValidSudoku::isValidSudoku2(vector<vector<char>>& board) {
	int rows[9] = { 0 };
	int cols[9] = { 0 };
	int boxs[9] = { 0 };

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				int value = 1 << (board[i][j] - '0' - 1);

				// 检查行
				if ((rows[i] & value) > 0) {
					return false;
				} else {
					rows[i] |= value;
				}
				// 检查列
				if ((cols[j] & value) > 0) {
					return false;
				} else {
					cols[j] |= value;
				}
				// 检查box
				if ((boxs[i / 3 * 3 + j / 3] & value) > 0) {
					return false;
				} else {
					boxs[i / 3 * 3 + j / 3] |= value;
				}
			}
		}
	}

	return true;
}