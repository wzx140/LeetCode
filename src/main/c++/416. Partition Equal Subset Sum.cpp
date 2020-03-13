#include "header/PartitionEqualSubsetSum.h"

#include <numeric>

using std::accumulate;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */

 /**
  * 类似0-1背包问题
  * 求解思路：dp[i][w]：只能携带前i个物品，最大负重量为w的情况下，携带的物品的最大的价值量
  * dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]]+value[i])
  *
  * 滚动数组优化：https://www.okcode.net/article/25975
  * dp[w]：最大负重量为w的情况下，携带的物品的最大的价值量
  * dp[w] = max(dp[w], dp[w-weight[i]]+value[i])
  * 注意反向循环，dp数组中前w为当前阶段的值，后w为前一个阶段的值
  */

  /**
   * 动态规划
   * 如果能够组合成sum(nums)/2，说明可以分隔成两个相等的序列
   * dp[i][j]：前i个数，是否能组合成j
   * dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
   * time:O(nc),c为数组和的一半
   * space:O(nc)
   */
bool PartitionEqualSubsetSum::canPartition1(vector<int>& nums) {
	int len = nums.size();

	int sum = accumulate(nums.begin(), nums.end(), 0);
	if (sum % 2 != 0) {
		return false;
	}

	int target = sum / 2;
	vector<vector<bool>> dp(len + 1, vector<bool>(target + 1, false));
	for (int i = 0; i < len; i++) {
		dp[i][0] = true;
	}

	for (int i = 1; i <= len; i++) {
		for (int j = 1; j <= target; j++) {
			if (j - nums[i - 1] > 0) {
				dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
			}
		}
	}

	return dp[len - 1][target];
}

/**
 * 动态规划
 * 对第一种方法优化
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 * dp[i]：前i个数，是否能组合成j
 * time:O(nc),c为数组和的一半
 * space:O(n)
 */
bool PartitionEqualSubsetSum::canPartition2(vector<int>& nums) {
	int len = nums.size();

	int sum = accumulate(nums.begin(), nums.end(), 0);
	if (sum % 2 != 0) {
		return false;
	}

	int target = sum / 2;
	vector<bool> dp(target + 1, false);
	dp[0] = true;

	for (int i = 1; i <= len; i++) {
		for (int j = target; j >= 1; j--) {
			if (j - nums[i - 1] > 0) {
				dp[j] = dp[j] || dp[j - nums[i - 1]];
			}
		}
	}

	return dp[target];
}