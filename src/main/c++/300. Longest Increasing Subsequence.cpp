#include "header/LongestIncreasingSubsequence.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */

 /**
  * 动态规划
  * dp[i]：以nums[i]结尾的最长升序子序列
  * time:O(n^2)
  * space:O(n)
  */
int LongestIncreasingSubsequence::lengthOfLIS1(vector<int>& nums) {
	int len = nums.size();
	if (len == 0) {
		return 0;
	}
	vector<int> dp(nums.size(), 1);

	int maxLen = 1;
	for (int i = 1; i < len; i++) {
		// 以nums[i]结尾的子序列的最大长度
		for (int j = 0; j < i; j++) {
			if (nums[j] < nums[i]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		maxLen = max(maxLen, dp[i]);
	}

	return maxLen;
}
