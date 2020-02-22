#include "header/ZigZagConversion.h"

#include <sstream>
#include <string>
#include <algorithm>
#include <vector>

using std::stringstream;
using std::string;
using std::min;
using std::vector;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */

 /**
  * 先遍历字符，构建ZigZag二维矩阵，再输出
  * time:O(n)
  * space:O(n)
  */
string ZigZagConversion::convert1(string s, int numRows) {
	int length = s.length();

	if (numRows == 1) {
		return s;
	}

	// 二维矩阵的列
	int col = 0;
	int remain = length % (2 * numRows - 2);	// zigzag多余的元素个数
	if (length % (2 * numRows - 2) == 0) {
		col = length / (2 * numRows - 2)*(numRows - 1);	// 不存在多余元素
	} else {
		col = length / (2 * numRows - 2)*(numRows - 1) + (remain - numRows > 0 ? remain - numRows + 1 : 1);	//存在多余元素
	}

	vector<vector<int>> zigZag(numRows, vector<int>(col, -1));

	// 构建矩阵
	int index = 0;
	for (int j = 0; j < col; j++) {
		if (j % (numRows - 1) == 0) {
			// 两侧竖线
			for (int i = 0; i < numRows; i++) {
				zigZag.at(i).at(j) = index++;
				if (index >= length) {
					break;
				}
			}
		} else {
			zigZag.at(numRows - 1 - j % (numRows - 1)).at(j) = index++;
			if (index >= length) {
				break;
			}
		}
	}

	// 构建输出字符串
	stringstream res;
	for (int i = 0; i < numRows; i++) {
		for (int j = 0; j < col; j++) {
			int index = zigZag.at(i).at(j);
			if (index != -1) {
				res << s.at(index);
			}
		}
	}

	return res.str();
}

/**
 * 同样先遍历，以行构建字符串数组(本质上是二维字符数组)，再输出
 * 相比上面一种方法，同样是构建了二维字符数组，但是本方法没有保持zigzag的形状，只保持了行的顺序，所以减少了计算量
 * time:O(n)
 * space:O(n)
 */
string ZigZagConversion::convert2(string s, int numRows) {

	if (numRows == 1) {
		return s;
	}

	vector<string> rows(min((int)s.length(), numRows));	// 以行构建的字符串数组
	bool down = true;	// 向下移

	int currRow = 0;
	for (char c : s) {
		rows[currRow] += c;
		if (currRow == 0) {
			down = true;
		} else if (currRow == numRows - 1) {
			down = false;
		}
		currRow = down ? currRow + 1 : currRow - 1;
	}

	string res;
	for (const string& row : rows) {
		res += row;
	}
	return res;
}

/**
 * 以行遍历zigzag，由s的下标计算而来
 * 相比前一种方法，占用空间减少了
 * time:O(n)
 * space:O(n)
 */
string ZigZagConversion::convert3(string s, int numRows) {

	if (numRows == 1) {
		return s;
	}

	int cycle = 2 * numRows - 2;	// 周期
	int length = s.length();

	string res;
	for (int i = 0; i < numRows; i++) {

		// zigzag中的右移相当于index移动一个周期
		for (int index = i; index < length; index += cycle) {

			// 夹在两个周期的中间数在该循环中的位置
			int middle = cycle - i;

			// 中间数在字符串中的下标
			middle += index - i;

			// 首尾才有中间值
			if (i != 0 && i != numRows - 1 && middle < length) {
				res += s[index];
				res += s[middle];
			} else {						
				res += s[index];
			}
		}
	}

	return res;
}
