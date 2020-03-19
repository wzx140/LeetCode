#include "header/HouseRobber2.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */

 /**
 * 动态规划
 * dp[i]：打劫前i个房屋的最大收益
 * dp[i]=max(dp[i-1], dp[i-2]+nums[i])
 */

 /**
  * 打劫1~n-1或者2~n，取最大值
  * time:O(n)
  * space:O(n)
  */
int HouseRobber2::rob1(vector<int>& nums) {
	if (nums.empty()) {
		return 0;
	}
	if (nums.size() == 1) {
		return nums[0];
	}

	int len = nums.size();
	// 哨兵
	vector<int> dp(len + 1, 0);
	// 1~n-1
	for (int i = 2; i <= len; i++) {
		dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 2]);
	}
	int max1 = dp[len];
	// 2~n
	for (int i = 2; i <= len; i++) {
		dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1]);
	}
	int max2 = dp[len];

	return max(max1, max2);
}

/**
 * 滚动数组优化
 * time:O(n)
 * space:O(1)
 */
int HouseRobber2::rob2(vector<int>& nums) {
	if (nums.empty()) {
		return 0;
	}
	if (nums.size() == 1) {
		return nums[0];
	}

	int len = nums.size();
	int dp_i = 0;
	int dp_i1 = 0;
	int dp_i2 = 0;
	// 1~n-1
	for (int i = 0; i < len - 1; i++) {
		dp_i = max(dp_i1, dp_i2 + nums[i]);
		dp_i2 = dp_i1;
		dp_i1 = dp_i;
	}
	int max1 = dp_i;
	// 2~n
	dp_i1 = 0;
	dp_i2 = 0;
	for (int i = 1; i < len; i++) {
		dp_i = max(dp_i1, dp_i2 + nums[i]);
		dp_i2 = dp_i1;
		dp_i1 = dp_i;
	}
	int max2 = dp_i;

	return max(max1, max2);
}