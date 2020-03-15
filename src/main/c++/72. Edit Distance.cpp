#include "header/EditDistance.h"

#include <algorithm>

using std::min;

/**
 * https://leetcode.com/problems/edit-distance/
 */

 /**
  * 参考解法：https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/bian-ji-ju-li
  * 与1143. Longest Common Subsequence类似
  * 字符串类的动归问题：两个指针分别指向两个字符串尾部，向前移动直到求解完成
  * 每次有四种移动方式：1. 当两个字符相等时，什么都不做，两个指针都向前移动
  * 2. 插入字符，被插入的字符串的指针不移动，另一个指针向前移动
  * 3. 删除字符，被删除的字符串的指针向前移到，另一个指针不移动
  * 4. 替换字符，替换后，两个指针都向前移动
  */

  /**
   * 递归+备忘录，自顶向下
   * 不等：recursive(i,j)=min(recursive(i,j-1),recursive(i-1,j),recursive(i-1,j-1))
   * 相等：recursive(i,j)=recursive(i-1,j-1)
   * time:O(mn)
   * space:O(mn)
   */
int EditDistance::minDistance1(string word1, string word2) {
	int len1 = word1.size();
	int len2 = word2.size();
	vector<vector<int>> memo(len1, vector<int>(len2, -1));
	return recursive(word1, word2, len1 - 1, len2 - 1, memo);
}

int EditDistance::recursive(string& word1, string& word2, int i, int j, vector<vector<int>>& memo) {
	if (i < 0 || j < 0) {
		return (i < 0 ? 0 : i + 1) + (j < 0 ? 0 : j + 1);
	}

	if (memo[i][j] != -1) {
		return memo[i][j];
	}

	int distance = 0;
	if (word1[i] == word2[j]) {
		distance = recursive(word1, word2, i - 1, j - 1, memo);
	} else {
		distance = min(recursive(word1, word2, i, j - 1, memo) + 1,
			recursive(word1, word2, i - 1, j, memo) + 1);
		distance = min(distance, recursive(word1, word2, i - 1, j - 1, memo) + 1);
	}

	memo[i][j] = distance;

	return distance;
}


/**
 * 动态规划，自底向上
 * dp[i][j]：两个字符串指针的位置，最小编辑距离
 * 不等：dp[i][j]=min(dp(i,j-1),dp(i-1,j),dp(i-1,j-1))
 * 相等：dp[i][j]=dp[i-1][j-1]
 * time:O(mn)
 * space:O(mn)
 */
int EditDistance::minDistance2(string word1, string word2) {
	int len1 = word1.size();
	int len2 = word2.size();
	vector<vector<int>> dp(len1 + 1, vector<int>(len2 + 1, 0));
	// 边界条件
	for (int i = 1; i <= len1; i++) {
		dp[i][0] = i;
	}
	for (int i = 1; i <= len2; i++) {
		dp[0][i] = i;
	}

	for (int i = 1; i <= len1; i++) {
		for (int j = 1; j <= len2; j++) {
			if (word1[i - 1] == word2[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1];
			} else {
				dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
				dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + 1);
			}
		}
	}
	return dp[len1][len2];
}
