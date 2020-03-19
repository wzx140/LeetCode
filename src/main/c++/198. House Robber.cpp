#include "header/HouseRobber.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/house-robber/
 */

 /**
  * 动态规划
  * dp[i]：打劫前i个房屋的最大收益
  * dp[i]=max(dp[i-1], dp[i-2]+nums[i])
  */

  /**
  * 动态规划
  * time:O(n)
  * space:O(n)
  */
int HouseRobber::rob1(vector<int>& nums) {
	if (nums.empty()) {
		return 0;
	}

	int len = nums.size();
	// 哨兵
	vector<int> dp(len + 2, 0);
	for (int i = 2; i <= len + 1; i++) {
		dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 2]);
	}

	return dp[len + 1];
}

/**
 * 滚动数组优化
 * time:O(n)
 * space:O(1)
 */
int HouseRobber::rob2(vector<int>& nums) {
	if (nums.empty()) {
		return 0;
	}

	int len = nums.size();
	int dp_i = 0;
	int dp_i1 = 0;
	int dp_i2 = 0;
	for (int i = 0; i < len; i++) {
		dp_i = max(dp_i1, dp_i2 + nums[i]);
		dp_i2 = dp_i1;
		dp_i1 = dp_i;
	}

	return dp_i;
}