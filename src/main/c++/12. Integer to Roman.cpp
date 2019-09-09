#include "Header.h"
#include <sstream>
#include <map>

using std::make_pair;
using std::map;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */

 /**
  * 直接由高到低判断，并对罗马数字进行组合
  * time:O(1)
  * space:O(1)
  */
string IntegerToRoman::intToRoman1(int num) {
	// 映射表
	char romanMap[7] = { 'I','V','X','L','C','D','M' };

	std::stringstream ss;

	int symbolNum = 0;

	symbolNum = num / 1000;
	if (symbolNum != 0) {			// >1000

		for (int i = 0; i < symbolNum; i++) {
			ss << romanMap[6];
		}
		num -= 1000 * symbolNum;
	}

	symbolNum = num / 500;
	if (symbolNum != 0) {			// 500~1000

		if (num / 100 == 9) {	// 特殊情况

			ss << romanMap[4] << romanMap[6];
			num -= 900;

		} else {
			for (int i = 0; i < symbolNum; i++) {
				ss << romanMap[5];
			}
			num -= 500 * symbolNum;
		}
	}

	symbolNum = num / 100;
	if (symbolNum != 0) {			// 100~500

		if (num / 100 == 4) {

			ss << romanMap[4] << romanMap[5];
			num -= 400;

		} else {
			for (int i = 0; i < symbolNum; i++) {
				ss << romanMap[4];
			}
			num -= 100 * symbolNum;
		}
	}

	symbolNum = num / 50;
	if (symbolNum != 0) {			// 50~100

		if (num / 10 == 9) {	// 特殊情况

			ss << romanMap[2] << romanMap[4];
			num -= 90;

		} else {
			for (int i = 0; i < symbolNum; i++) {
				ss << romanMap[3];
			}
			num -= 50 * symbolNum;
		}
	}

	symbolNum = num / 10;
	if (symbolNum != 0) {			// 10~50

		if (num / 10 == 4) {	// 特殊情况

			ss << romanMap[2] << romanMap[3];
			num -= 40;

		} else {
			for (int i = 0; i < symbolNum; i++) {
				ss << romanMap[2];
			}
			num -= 10 * symbolNum;
		}
	}

	symbolNum = num / 5;
	if (symbolNum != 0) {				// 5~10

		if (num == 9) {	// 特殊情况

			ss << romanMap[0] << romanMap[2];
			num -= 9;

		} else {
			for (int i = 0; i < symbolNum; i++) {
				ss << romanMap[1];
			}
			num -= 5 * symbolNum;
		}

	}

	if (num != 0) {						// <5

		if (num == 4) {		// 特殊情况
			ss << romanMap[0] << romanMap[1];

		} else {
			for (int i = 0; i < num; i++) {
				ss << romanMap[0];
			}
		}
	}

	return ss.str();
}

/**
  * 更简洁的方式
  * time:O(1)
  * space:O(1)
  */
string IntegerToRoman::intToRoman2(int num) {
	// 映射表
	map<int, string> romanMap;
	romanMap.insert(make_pair(1, "I"));
	romanMap.insert(make_pair(4, "IV"));
	romanMap.insert(make_pair(5, "V"));
	romanMap.insert(make_pair(9, "IX"));
	romanMap.insert(make_pair(10, "X"));
	romanMap.insert(make_pair(40, "XL"));
	romanMap.insert(make_pair(50, "L"));
	romanMap.insert(make_pair(90, "XC"));
	romanMap.insert(make_pair(100, "C"));
	romanMap.insert(make_pair(400, "CD"));
	romanMap.insert(make_pair(500, "D"));
	romanMap.insert(make_pair(900, "CM"));
	romanMap.insert(make_pair(1000, "M"));

	std::stringstream ss;

	for (map<int, string>::reverse_iterator rit = romanMap.rbegin(); rit != romanMap.rend(); rit++) {
		int arab = rit->first;
		string roman = rit->second;
		if (num >= arab) {
			while (num >= arab) {
				num -= arab;
				ss << roman;
			}
		}
	}

	return ss.str();
}