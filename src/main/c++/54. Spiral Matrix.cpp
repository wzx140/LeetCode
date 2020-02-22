#include "header/SpiralMatrix.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::min;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */

 /**
  * 模拟实际螺旋路线，依次输出元素
  * time:O(n)
  * space:O(n)
  */
vector<int> SpiralMatrix::spiralOrder1(vector<vector<int>>& matrix) {
	vector<int> res;
	if (matrix.empty()) {
		return res;
	}

	int rowLength = matrix.size();
	int colLength = matrix[0].size();

	// 四个方向，右，下，左，上
	vector<vector<int>> dirMode = { {0,1},{1,0},{0,-1},{-1,0} };
	// 当前方向
	int dir = 0;
	// 当前位置
	int row = 0, col = 0;
	for (int i = 0; i < rowLength*colLength; i++) {
		res.push_back(matrix[row][col]);

		// 是否接触到限位开关
		if (dir == 0) {
			if (col == colLength - row - 1) {
				dir = 1;
			}
		} else if (dir == 1) {
			if (row == rowLength - (colLength - 1 - col) - 1) {
				dir = 2;
			}
		} else if (dir == 2) {
			if (col == rowLength - 1 - row) {
				dir = 3;
			}
		} else {
			if (row == col + 1) {
				dir = 0;
			}
		}

		row += dirMode[dir][0];
		col += dirMode[dir][1];
	}

	return res;
}

/**
 * 按照每层元素的索引规律，按层添加
 * time:O(n)
 * space:O(n)
 */
vector<int> SpiralMatrix::spiralOrder2(vector<vector<int>>& matrix) {
	vector<int> res;
	if (matrix.empty()) {
		return res;
	}

	int rowLength = matrix.size();
	int colLength = matrix[0].size();
	int layerLength = (min(rowLength, colLength) + 1) / 2;

	for (int layer = 0; layer < layerLength; layer++) {
		// 上部
		for (int col = layer; col < colLength - layer; col++) {
			res.push_back(matrix[layer][col]);
		}
		// 右部
		for (int row = layer + 1; row < rowLength - layer; row++) {
			res.push_back(matrix[row][colLength - 1 - layer]);
		}
		// 下部
		if (rowLength - 1 - layer != layer) {
			for (int col = colLength - 1 - layer - 1; col >= layer + 1; col--) {
				res.push_back(matrix[rowLength - 1 - layer][col]);
			}
		}
		// 左部
		if (layer != colLength - 1 - layer) {
			for (int row = rowLength - 1 - layer; row >= layer + 1; row--) {
				res.push_back(matrix[row][layer]);
			}
		}
	}

	return res;
}
