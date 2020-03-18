#include "header/BTBSS4.h"

#include <algorithm>
#include <limits>

using std::max;
using std::numeric_limits;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */

 /**
  * 动态规划
  * dp[i][k][state]：i:当前天数；k:当前最多进行了k次交易；state:当前是否持有股票，0没有，1持有
  * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
  * dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
  */

  /**
   * 动态规划
   * time:O(nk)
   * space:O(nk)
   */
int BTBSS4::maxProfit1(int k, vector<int>& prices) {
	if (prices.empty()) {
		return 0;
	}

	int len = prices.size();
	// 防止超出内存错误
	if (k > len / 2) {
		// 这时相当于无限制交易次数
		// 见122. best time to buy and sell stock II
		int lastHold = numeric_limits<int>::min();
		int lastNHold = 0;
		for (int i = 0; i < len; i++) {
			int tmp = lastNHold;
			lastNHold = max(lastNHold, lastHold + prices[i]);
			lastHold = max(lastHold, tmp - prices[i]);
		}
		return lastNHold;
	}

	vector<vector<vector<int>>> dp(len + 1, vector<vector<int>>(k + 1, vector<int>(2, 0)));

	// 边界条件
	for (int i = 0; i <= len; i++) {
		// 未发生交易的情况下，不可能持有股票
		dp[i][0][1] = numeric_limits<int>::min();
	}
	for (int i = 0; i <= k; i++) {
		dp[0][i][1] = numeric_limits<int>::min();
	}

	for (int i = 1; i <= len; i++) {
		for (int j = 1; j <= k; j++) {
			// dp数组中最前面放了哨兵，所以prices[i-1]
			dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
			dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
		}
	}

	return dp[len][k][0];
}