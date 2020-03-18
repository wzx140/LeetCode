#include "header/BTBSS1.h"

#include <algorithm>
#include <limits>

using std::numeric_limits;
using std::max;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

 /**
  * 动态规划
  * dp[i][k][state]：i:当前天数；k:当前最多进行了k次交易；state:当前是否持有股票，0没有，1持有；当前最大收益
  * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
  * dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
  */

  /**
   * 压缩dp数组
   * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
   *             =max(dp[i-1][0], dp[i-1][1] + prices[i])
   * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])=max(dp[i-1][1][1], -prices[i])
   *		     =max(dp[i-1][1], -prices[i])
   * time:O(n)
   * space:O(n)
   */
int BTBSS1::maxProfit1(vector<int>& prices) {
	if (prices.empty()) {
		return 0;
	}

	int len = prices.size();

	// 最大交易次数为1，所以压缩dp数组dp[i][state]
	vector<vector<int>> dp(len + 1, vector<int>(2, 0));

	// 边界条件
	// 股市开市前
	dp[0][0] = 0;
	dp[0][1] = numeric_limits<int>::min();

	for (int i = 1; i <= len; i++) {
		// dp数组中最前面放了哨兵，所以prices[i-1]
		dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
		dp[i][1] = max(dp[i - 1][1], - prices[i - 1]);
	}

	return dp[len][0];
}

/**
 * 滚动数组优化：更新dp[i][0/1]时只用到了dp[i - 1][0/1]
 * time:O(n)
 * space:O(1)
 */
int BTBSS1::maxProfit2(vector<int>& prices) {
	if (prices.empty()) {
		return 0;
	}

	int len = prices.size();

	// 上一次持有
	int lastHold = numeric_limits<int>::min();
	// 上一次未持有
	int lastNHold = 0;

	for (int i = 0; i < len; i++) {
		lastNHold = max(lastNHold, lastHold + prices[i]);
		lastHold = max(lastHold, -prices[i]);
	}

	return lastNHold;
}