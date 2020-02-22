#include "header/CountSay.h"

#include <string>

using std::string;

/**
 * https://leetcode.com/problems/count-and-say/
 */

 /**
  * 直接迭代计算
  * time:O(2^n)
  * space:O(2^(n-1))
  */
string CountSay::countAndSay1(int n) {
	string res = "1";
	for (int i = 1; i < n; i++) {
		int freq = 1;
		char lastTerm = res[0];
		string next;
		// 转变重复term
		for (int j = 1; j < res.size(); j++) {
			if (lastTerm == res[j]) {
				freq++;
			} else {
				next += freq + '0';
				next += lastTerm;
				freq = 1;
				lastTerm = res[j];
			}
		}
		next += freq + '0';
		next += lastTerm;

		res = next;
	}

	return res;
}
