#include "header/PalindromeNumber.h"

#include <string>
#include <algorithm>
using std::string;
using std::to_string;
using std::reverse_copy;

/**
 * https://leetcode.com/problems/palindrome-number/
 */

/**
 * 转化为字符串，进行处理
 * time:O(n)
 * space:O(n)
 */
bool PalindromeNumber::isPalindrome1(int x) {

	// 负数，以0结尾的非零数，肯定不回文
	if (x < 0 || (x % 10 == 0 && x != 0)) {
		return false;
	}

	string a = to_string(x);
	int length = a.length();
	string aReverse(length, '\0');
	reverse_copy(a.begin(), a.end(), aReverse.begin());

	for (int i = 0; i < length; i++) {
		if (a.at(i) != aReverse.at(i)) {
			return false;
		}
	}
	return true;
};

/**
 * 逆转数字，会溢出
 * time:O(n)
 * space:O(1)
 */
bool PalindromeNumber::isPalindrome2(int x) {
	if (x < 0 || (x % 10 == 0 && x != 0)) {
		return false;
	}

	int origin = x;

	int reverseX = 0;
	while (x > 0) {
		reverseX *= 10;
		reverseX += x % 10;
		x /= 10;
	}

	if (reverseX == origin) {
		return true;
	} else {
		return false;
	}
};

/**
 * 逆转一半的数字
 * time:O(n)
 * space:O(1)
 */
bool PalindromeNumber::isPalindrome3(int x) {
	if (x < 0 || (x % 10 == 0 && x != 0)) {
		return false;
	}

	int reverseX = 0;
	while (x > reverseX) {
		reverseX *= 10;
		reverseX += x % 10;
		x /= 10;
	}

	if (reverseX == x) {				// 偶数长度
		return true;
	} else if (reverseX / 10 == x) {	// 奇数长度
		return true;
	} else {
		return false;
	}
};
