#include "header/LongestCommonSubsequence.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */

 /**
  * 参考解法：https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zui-chang-gong-gong-zi-xu-lie
  * 与72. Edit Distance类似
  * 字符串类的动归问题：两个指针分别指向两个字符串尾部，向前移动直到求解完成
  * 每次有两种移动方式：1. 当两个字符相等时，两个指针都向前移动，计入公共序列中
  * 2. 当两个字符不相等时，丢弃其中一个字符，取最大值(两个字符最多只有一个在公共序列中)
  */

  /**
   * 递归+备忘录，自顶向下
   * 不等：recursive(i,j)=max(recursive(i,j-1),recursive(i-1,j))
   * 相等：recursive(i,j)=recursive(i-1,j-1)+1
   * time:O(mn)
   * space:O(mn)
   */
int LongestCommonSubsequence::longestCommonSubsequence1(string text1, string text2) {
	int len1 = text1.size();
	int len2 = text2.size();
	vector<vector<int>> memo(len1, vector<int>(len2, -1));
	return recursive(text1, text2, len1 - 1, len2 - 1, memo);
}

int LongestCommonSubsequence::recursive(string& text1, string& text2, int i, int j, vector<vector<int>>& memo) {
	if (i < 0 || j < 0) {
		return 0;
	}

	if (memo[i][j] != -1) {
		return memo[i][j];
	}

	int size = 0;
	if (text1[i] == text2[j]) {
		size = recursive(text1, text2, i - 1, j - 1, memo) + 1;
	} else {
		size = max(recursive(text1, text2, i - 1, j, memo), recursive(text1, text2, i, j - 1, memo));
	}
	memo[i][j] = size;
	return size;
}

/**
 * 动态规划，自底向上
 * dp[i][j]：两个字符串指针的位置，最大公共序列长度
 * 不等：dp[i][j]=max(dp(i,j-1),dp(i-1,j))
 * 相等：dp[i][j]=dp[i-1][j-1]+1
 * time:O(mn)
 * space:O(mn)
 */
int LongestCommonSubsequence::longestCommonSubsequence2(string text1, string text2) {
	int len1 = text1.size();
	int len2 = text2.size();
	vector<vector<int>> dp(len1 + 1, vector<int>(len2 + 1, -1));
	// 边界条件
	for (int i = 0; i < len1 + 1; i++) {
		dp[i][0] = 0;
	}
	for (int i = 0; i < len2 + 1; i++) {
		dp[0][i] = 0;
	}

	for (int i = 1; i < len1 + 1; i++) {
		for (int j = 1; j < len2 + 1; j++) {
			if (text1[i - 1] == text2[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			} else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
	return dp[len1][len2];
}