#include "Header.h"

#include <algorithm>

using std::max;
using std::reverse;

// 超出时间限制 time:O(n3) space:O(n)
string LongestPalindromicSubstring::longestPalindrome1(string s) {
	int length = s.length();
	int maxStart = 0;
	int maxEnd = 0;
	for (int i = 0; i < length - 1; i++) {
		for (int j = i + 1; j < length; j++) {
			int isPalindrome = true;
			for (int k = 0; k < (j - i + 1) / 2; k++) {
				if (s[i + k] != s[j - k]) {
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome && (maxEnd - maxStart) < (j - i)) {
				maxStart = i;
				maxEnd = j;
			}
		}
	}
	return s.substr(maxStart, maxEnd - maxStart + 1);
}

// 逆转字符串，找到最长公共子串 time:O(n2) space:O(n2)
string LongestPalindromicSubstring::longestPalindrome2(string s) {
	int length = s.length();
	string reverseS = s;
	reverse(reverseS.begin(), reverseS.end());

	int maxLength = 0;
	int startIndex = 0;	// 最长回文起索引

	// 动态规划，构造二维矩阵求最长公共子串
	vector<vector<int>> matrix(length + 1, vector<int>(length + 1, 0));
	for (int i = 0; i < length; i++) {
		matrix.at(0).at(i) = 0;	// 第一行为0
	}
	for (int i = 0; i < length; i++) {
		matrix.at(i).at(0) = 0;	// 第一列为0
	}
	for (int i = 1; i < length + 1; i++) {
		for (int j = 1; j < length + 1; j++) {
			if (reverseS.at(j - 1) == s.at(i - 1)) {
				int currLength = matrix.at(i - 1).at(j - 1) + 1;
				matrix.at(i).at(j) = currLength;

				// 可能出现错误的答案，判断是否是回文串
				if (currLength > maxLength && length - j == i - currLength) {
					maxLength = currLength;
					startIndex = i - currLength;
				}
			}
		}
	}
	return s.substr(startIndex, maxLength);
}

// 动态规划，保存字符串是否是回文，避免重复判断 time:O(n2) space:O(n2)
string LongestPalindromicSubstring::longestPalindrome3(string s) {
	int length = s.length();
	vector<vector<bool>> matrix(length, vector<bool>(length, false));	// 保存 p(i,j)是否是回文

	int maxLength = 0;
	int maxStart = 0;
	int maxEnd = 0;

	// 长度为1和2的单独判断
	for (int i = 0; i < length; i++) {
		matrix.at(i).at(i) = true;
	}
	for (int i = 0; i < length - 1; i++) {
		if (s.at(i) == s.at(i + 1)) {
			matrix.at(i).at(i + 1) = true;
			if (maxLength < 2) {
				maxLength = 2;
				maxStart = i;
				maxEnd = i + 1;
			}
		}
	}

	// 从长度为3开始循环判断
	for (int i = 2; i < length + 1; i++) {
		for (int start = 0; start < length; start++) {
			int end = start + i;

			if (end >= length) {
				break;
			}

			// 判断首尾是否一样，子串是否是回文
			if (s.at(start) == s.at(end) && matrix.at(start + 1).at(end - 1)) {
				matrix.at(start).at(end) = true;
				if ((end - start + 1) > maxLength) {
					maxStart = start;
					maxEnd = end;
					maxLength = end - start + 1;
				}
			} else {
				matrix.at(start).at(end) = false;
			}
		}
	}

	return s.substr(maxStart, maxLength);
}

// 从start和end向外拓展，输出最长的回文串长度
int expend(string s, int start, int end) {
	int length = s.length();
	while (start >= 0 && end < length&&s.at(start) == s.at(end)) {
		start--;
		end++;
	}
	return end - start - 1;
}

// 中心拓展算法
string LongestPalindromicSubstring::longestPalindrome4(string s) {
	int length = s.length();

	int maxLength = 0;
	int maxStart = 0;
	int maxEnd = 0;

	for (int i = 0; i < length; i++) {
		int length1 = expend(s, i, i);	// 从i处向外拓展
		int length2 = expend(s, i, i + 1);	// 从i与i+1的中间向外拓展
		int resLength = max(length1, length2);
		if (resLength > maxLength) {
			// 两种不同的拓展中心点，可以用一个表达式表示两端的点
			maxStart = -(resLength - 1) / 2 + i;
			maxEnd = resLength / 2 + i;
			maxLength = resLength;
		}
	}

	return s.substr(maxStart, maxLength);
}
