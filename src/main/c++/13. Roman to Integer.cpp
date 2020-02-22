#include "header/RomanToInteger.h"
#include <map>

using std::make_pair;
using std::map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */

 /**
  * 直接由高到低判断，并对罗马数字进行组合
  * time:O(logn)
  * space:O(1)
  */
int RomanToInteger::romanToInt(string s) {
	// 映射表
	map<string, int> romanMap;
	romanMap.insert(make_pair("I", 1));
	romanMap.insert(make_pair("IV", 4));
	romanMap.insert(make_pair("V", 5));
	romanMap.insert(make_pair("IX", 9));
	romanMap.insert(make_pair("X", 10));
	romanMap.insert(make_pair("XL", 40));
	romanMap.insert(make_pair("L", 50));
	romanMap.insert(make_pair("XC", 90));
	romanMap.insert(make_pair("C", 100));
	romanMap.insert(make_pair("CD", 400));
	romanMap.insert(make_pair("D", 500));
	romanMap.insert(make_pair("CM", 900));
	romanMap.insert(make_pair("M", 1000));

	int length = s.length();

	int res = 0;
	int index = 0;
	while (index < length) {

		if (index == length - 1) {		// 最后一个数
			res += romanMap.at(s.substr(index, 1));
			index++;
		} else {
			map<string, int>::iterator it = romanMap.find(s.substr(index, 2));
			if (it != romanMap.end()) {	// 两个字符
				res += it->second;
				index += 2;
			} else {					// 单个字符
				res += romanMap.at(s.substr(index, 1));
				index += 1;
			}
		}
	}

	return res;
}
