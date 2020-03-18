#include "header/BTBSS3.h"

#include <algorithm>
#include <limits>

using std::max;
using std::numeric_limits;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

 /**
  * 动态规划
  * dp[i][k][state]：i:当前天数；k:当前最多进行了k次交易；state:当前是否持有股票，0没有，1持有
  * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
  * dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
  */

  /**
   * 动态规划
   * time:O(n)
   * space:O(n)
   */
int BTBSS3::maxProfit1(vector<int>& prices) {
	if (prices.empty()) {
		return 0;
	}

	int len = prices.size();
	vector<vector<vector<int>>> dp(len + 1, vector<vector<int>>(3, vector<int>(2, 0)));

	// 边界条件
	for (int i = 0; i <= len; i++) {
		// 未发生交易的情况下，不可能持有股票
		dp[i][0][1] = numeric_limits<int>::min();
	}
	dp[0][0][1] = numeric_limits<int>::min();
	dp[0][1][1] = numeric_limits<int>::min();
	dp[0][2][1] = numeric_limits<int>::min();

	for (int i = 1; i <= len; i++) {
		for (int k = 1; k <= 2; k++) {
			// dp数组中最前面放了哨兵，所以prices[i-1]
			dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
			dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
		}
	}

	return dp[len][2][0];
}

/**
 * 滚动数组优化：更新dp[i][1/2][0/1]时只用到了dp[i - 1][1/2][0/1]
 * time:O(n)
 * space:O(n)
 */
int BTBSS3::maxProfit2(vector<int>& prices) {
	if (prices.empty()) {
		return 0;
	}

	int len = prices.size();
	int dp_i_2_0 = 0;
	int dp_i_2_1 = numeric_limits<int>::min();
	int dp_i_1_0 = 0;
	int dp_i_1_1 = numeric_limits<int>::min();

	for (int i = 0; i < len; i++) {
		dp_i_1_0 = max(dp_i_1_0, dp_i_1_1 + prices[i]);
		dp_i_1_1 = max(dp_i_1_1, -prices[i]);
		dp_i_2_0 = max(dp_i_2_0, dp_i_2_1 + prices[i]);
		dp_i_2_1 = max(dp_i_2_1, dp_i_1_0 - prices[i]);
	}

	return dp_i_2_0;
}