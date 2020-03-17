#include "header/StoneGame.h"

#include <map>

using std::pair;
using std::make_pair;

/**
 * https://leetcode.com/problems/stone-game/
 */

 /**
  * 动态规划
  * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-zhi-bo-yi-wen-ti
  * dp[i][j].first 表示，对于 i~j 这部分石头堆，先手能获得的最高分数。
  * dp[i][j].second 表示，对于 i~j 这部分石头堆，后手能获得的最高分数。
  * 先手：dp[i][j].fir = max(piles[i] + dp[i+1][j].sec, piles[j] + dp[i][j-1].sec)
  * 后手：if 先手选择左边:dp[i][j].sec = dp[i+1][j].fir；if 先手选择右边:dp[i][j].sec = dp[i][j-1].fir
  * 注意dp数组要斜着遍历
  */

  /**
   * 动态规划
   * time:O(n^2)
   * space:O(n^2)
   */
bool StoneGame::stoneGame1(vector<int>& piles) {
	int len = piles.size();
	vector<vector<pair<int, int>>> dp(len, vector<pair<int, int>>(len, make_pair(0, 0)));
	// 初始条件
	for (int i = 0; i < len; i++) {
		// 如果只剩一堆，只能被先手拿走
		dp[i][i].first = piles[i];
		dp[i][i].second = 0;
	}

	// 斜着遍历
	for (int i = 1; i < len; i++) {
		for (int j = 0; j < len - i; j++) {
			int st = j;
			int end = len - 1 - j;

			// 完成一组先手和后手的选择
			int left = dp[st + 1][end].second + piles[st];
			int right = dp[st][end - 1].second + piles[end];
			if (left > right) {
				dp[st][end].first = left;
				dp[st][end].second = dp[st + 1][end].first;
			} else {
				dp[st][end].first = right;
				dp[st][end].second = dp[st][end - 1].first;
			}
		}
	}

	return dp[len - 1][len - 1].first > dp[len - 1][len - 1].second;
}
