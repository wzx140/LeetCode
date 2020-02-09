#include "Header.h"

#include <string>
#include <vector>

using std::string;
using std::vector;

/**
 * https://leetcode.com/problems/multiply-strings/
 */

 /**
  * 基本的乘法运算
  * time:O(mn)
  * space:O(m+n)
  */
string MultiplyStrings::multiply1(string num1, string num2) {
	int length1 = num1.size();
	int length2 = num2.size();
	vector<int> val(length1 + length2, 0);

	for (int i = length1 - 1; i >= 0; i--) {
		for (int j = length2 - 1; j >= 0; j--) {
			int mul = (num1[i] - '0') * (num2[j] - '0');
			int bit = i + j;

			int sum = val[bit + 1] + mul;
			val[bit + 1] = sum % 10;
			val[bit] += sum / 10;
		}
	}

	string res;
	for (int num : val) {
		if (!res.empty() || num != 0) {
			res += (num + '0');
		}
	}

	return res.empty() ? "0" : res;
}
