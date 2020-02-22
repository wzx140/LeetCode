#include "header/LCPN.h"

#include <cmath>
#include <algorithm>

using std::pow;
using std::sort;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

 /**
  * 循环遍历，可以看看官方解答的树形图动画
  * time:O(3^n*4^m)
  * space:O(3^n*4^m)
  */
vector<string> LCPN::letterCombinations1(string digits) {

	if (digits.empty()) {
		return vector<string>();
	}

	int length = digits.length();

	char map[8][4] = { {'a','b','c','\0'},{'d','e','f','\0'},{'g','h','i','\0'},{'j','k','l','\0'},{'m','n','o','\0'} ,{ 'p','q','r','s' },{'t','u','v','\0'},{'w','x','y','z'} };

	// 计算结果个数
	int bit = 1;
	for (int i = 0; i < length; i++) {
		int num = digits.at(i) - 48;
		if (num != 7 && num != 9) {
			bit *= 3;
		} else {
			bit *= 4;
		}
	}

	vector<string> res(bit, "");

	// 循环因子，当前数字对应的每个字母在一个循环中重复的次数
	int factor = 1;

	// 每个数字都循环堆砌，规则由上层的
	for (int i = 0; i < length; i++) {
		int num = digits.at(i) - 48;

		// 数字对应的每个字母循环堆砌
		for (int j = 0; j < bit; j++) {

			// 当前数字对应的每个字母在一个循环中重复的次数
			int loopInterval = j / factor;

			if (num == 7 || num == 9) {
				res[j] += map[num - 2][loopInterval % 4];
			} else {
				res[j] += map[num - 2][loopInterval % 3];
			}

		}

		if (num == 7 || num == 9) {
			factor *= 4;
		} else {
			factor *= 3;
		}
	}

	//sort(res.begin(), res.end());
	return res;
}

void recursive(vector<string> &res, string combination, string digits, char map[][4]) {
	int length = digits.size();

	if (length == 0) {
		res.emplace_back(combination);
	} else {
		int num = digits.at(0) - 48;
		for (int i = 0; i < 4; i++) {
			char ch = map[num - 2][i];
			if (ch != '\0') {
				recursive(res, combination + ch, digits.substr(1, length - 1), map);
			} else {
				return;
			}
		}

	}
}

/**
 * 递归方法，其实思想与上一种方法一致，但是更简洁易懂
 * time:O(3^n*4^m)
 * space:O(3^n*4^m)
 */
vector<string> LCPN::letterCombinations2(string digits) {
	char map[8][4] = { {'a','b','c','\0'},{'d','e','f','\0'},{'g','h','i','\0'},{'j','k','l','\0'},{'m','n','o','\0'} ,{ 'p','q','r','s' },{'t','u','v','\0'},{'w','x','y','z'} };

	if (digits.empty()) {
		return vector<string>();
	}

	vector<string> res;
	recursive(res, "", digits, map);
	return res;
}

