#include "header/RegularExpressionMatching.h"

#include <vector>

using std::vector;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */

 /**
  * 动态规划
  * dp[i][j]：两个字符串指针的位置，当前位置及其之前是否匹配
  * 1. 当前位置是否匹配：p[j] == '.' || p[j] == s[i]，不匹配应该直接返回false
  * 2. 下一个位置是否是*
  * 3. 如果是，判断 dp[i + 1][j](多次)或dp[i][j+2](零次)
  * 4. 如果不是，判断 dp[i + 1][j+1]
  * time:O(mn)
  * space:O(mn)
  */
bool RegularExpressionMatching::isMatch1(string s, string p) {
	int len1 = s.size();
	int len2 = p.size();
	vector<vector<bool>> dp(len1 + 1, vector<bool>(len2 + 1, false));

	// 哨兵
	dp[len1][len2] = true;

	// 如果pattern中只有x*，那么空串是可以与pattern匹配的
	for (int i = len1; i >= 0; i--) {
		for (int j = len2 - 1; j >= 0; j--) {
			bool first = i < len1 && (p[j] == '.' || p[j] == s[i]);

			if (j < len2 - 1 && p[j + 1] == '*') {
				dp[i][j] = dp[i][j + 2] || (first && dp[i + 1][j]);
			} else {
				dp[i][j] = first && dp[i + 1][j + 1];
			}
		}
	}

	return dp[0][0];
}