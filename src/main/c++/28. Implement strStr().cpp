#include "header/ImplementStrStr.h"

#include <vector>

using std::vector;

/**
 * https://leetcode.com/problems/implement-strstr/
 */

 /**
  * 暴力破解
  * time:O(mn)
  * space:O(mn)
  */
int ImplementStrStr::strStr1(string haystack, string needle) {
	int hayLength = haystack.size();
	int needleLength = needle.size();

	if (needleLength == 0) {
		return 0;
	}

	for (int i = 0; i < hayLength; i++) {

		if (hayLength - i >= needleLength) {
			bool flag = true;
			for (int j = 0; j < needleLength; j++) {
				if (haystack.at(i + j) != needle.at(j)) {
					flag = false;
				}
			}
			if (flag) {
				return i;
			}
		}

	}

	return -1;
}

/**
 * 有限状态自动机
 * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-zhi-kmp-zi-fu-pi-pei-suan-fa
 * dp[i][c]:i当前pattern状态，c当前的触发字符
 * x:影子状态
 * time:O(m)
 * space:O(n)
 */
int ImplementStrStr::strStr2(string haystack, string needle) {
	if (needle.empty()) {
		return 0;
	}

	int len1 = haystack.size(), len2 = needle.size();

	vector<vector<char>> dp(len2, vector<char>(26, 0));
	dp[0][needle[0] - 97] = 1;

	// 影子状态
	int x = 0;
	// 由pattern构造dp数组
	for (int i = 1; i < len2; i++) {
		// 26个小写字母
		for (int j = 97; j <= 122; j++) {
			if (j == needle[i]) {
				dp[i][j - 97] = i + 1;
			} else {
				dp[i][j - 97] = dp[x][j - 97];
			}
		}
		// 寻找重复的起点
		x = dp[x][needle[i] - 97];
	}

	int state = 0;
	for (int i = 0; i < len1; i++) {
		state = dp[state][haystack[i] - 97];
		if (state == len2) {
			return i - len2 + 1;
		}
	}

	return -1;
}
