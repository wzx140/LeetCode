#include "Header.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::swap;

/**
 * https://leetcode.com/problems/rotate-image/
 */

 /**
  * https://masterwangzx.com/2019/02/19/rotate/#%E6%96%B9%E6%B3%95%E4%B8%80
  * time:O(n)
  * space:O(1)
  */
void RotateImage::rotate1(vector<vector<int>>& matrix) {
	int n = matrix.size();
	for (int row = 0; row < n / 2; row++) {
		for (int col = row; col < n - 1 - row; col++) {
			int curRow = row;
			int curCol = col;
			int target = matrix[curRow][curCol];

			for (int i = 0; i < 4; i++) {
				int nextRow = curCol;
				int nextCol = n - 1 - curRow;
				swap(target, matrix[nextRow][nextCol]);
				curRow = nextRow;
				curCol = nextCol;
			}
		}
	}
}

/**
 * https://masterwangzx.com/2019/02/19/rotate/#%E6%96%B9%E6%B3%95%E4%BA%8C
 * time:O(n)
 * space:O(1)
 */
void RotateImage::rotate2(vector<vector<int>>& matrix) {
	int n = matrix.size();
	// 转置
	for (int row = 0; row < n; row++) {
		for (int col = 0; col < row; col++) {
			swap(matrix[row][col], matrix[col][row]);
		}
	}
	// 横向翻转
	for (int row = 0; row < n; row++) {
		for (int col = 0; col < n / 2; col++) {
			swap(matrix[row][col], matrix[row][n - 1 - col]);
		}
	}
}

/**
 * https://masterwangzx.com/2019/02/19/rotate/#%E6%96%B9%E6%B3%95%E4%B8%89
 * time:O(n)
 * space:O(1)
 */
void RotateImage::rotate3(vector<vector<int>>& matrix) {
	int n = matrix.size();
	// 按斜对角线翻转
	for (int row = 0; row < n - 1; row++) {
		for (int col = 0; col < n - row - 1; col++) {
			swap(matrix[row][col], matrix[n - 1 - col][n - 1 - row]);
		}
	}
	// 纵向翻转
	for (int row = 0; row < n / 2; row++) {
		swap(matrix[row], matrix[n - 1 - row]);
	}
}