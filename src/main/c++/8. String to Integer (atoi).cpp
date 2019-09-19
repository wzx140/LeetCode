#include "Header.h"

#include <limits>

using std::numeric_limits;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */

 /**
  * 比较简单
  * time:O(1)
  * space:O(1)
  */
int Atoi::myAtoi1(string str) {
	if (str.empty()) {
		return 0;
	}

	int length = str.size();
	int res = 0;
	int negative = 1;

	// 去除首部空格
	int start = 0;
	while (start < length) {
		if(str.at(start) != ' '){
			break;
		}
		start++;
	}

	for (int i = start; i < length; i++) {
		char ch = str.at(i);

		if (i == start && str.at(i) == '+') {
			negative = 1;
		} else if (i == start && str.at(i) == '-') {
			negative = -1;

		} else if (ch >= 48 && ch <= 57) {

			// 是否溢出
			if (negative == 1 && (res > 214748364 || (res == 214748364 && ch - 48 >= 7))) {
				return numeric_limits<int>::max();
			}
			if (negative == -1 && (res > 214748364 || (res == 214748364 && ch - 48 >= 8))) {
				return numeric_limits<int>::min();
			}

			res *= 10;
			res += ch - 48;

		} else {
			return res * negative;
		}
	}

	return res * negative;
}
