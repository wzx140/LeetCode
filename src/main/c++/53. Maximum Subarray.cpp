#include "Header.h"

#include <vector>
#include <numeric>
#include <algorithm>

using std::vector;
using std::numeric_limits;
using std::max;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */

 /**
  * 暴力
  * time:O(n^2)
  * space:O(1)
  */
int MaximumSubarray::maxSubArray1(vector<int>& nums) {
	int maxSum = numeric_limits<int>::min();
	int length = nums.size();
	for (int i = 0; i < length; i++) {
		int sum = nums[i];
		maxSum = max(maxSum, sum);
		for (int j = i + 1; j < length; j++) {
			sum += nums[j];
			maxSum = max(maxSum, sum);
		}
	}

	return maxSum;
}

/**
 * 动态规划
 * time:O(n)
 * space:O(n)
 */
int MaximumSubarray::maxSubArray2(vector<int>& nums) {
	int length = nums.size();
	// 以当前元素结尾的子串的最大和，之所以用这样的结构是为了满足连续子串的条件
	// 也可以在原数组上修改，这样就是常数空间复杂度
	vector<int> dp(length, 0);
	dp[0] = nums[0];
	int maxSum = nums[0];
	for (int i = 1; i < length; i++) {
		dp[i] = max(nums[i], dp[i - 1] + nums[i]);
		maxSum = max(dp[i], maxSum);
	}
	return maxSum;
}

/**
 * 贪心，思想与动归差不多
 * time:O(n)
 * space:O(1)
 */
int MaximumSubarray::maxSubArray3(vector<int>& nums) {
	int length = nums.size();
	// 以当前元素结尾的子串的最大和
	int curMax = nums[0];
	// 全局最大和
	int maxSum = nums[0];
	for (int i = 1; i < length; i++) {
		curMax = max(nums[i], curMax + nums[i]);
		maxSum = max(curMax, maxSum);
	}
	return maxSum;
}

/**
 * 分治，比较难想到，也不是最优解
 * time:O(nlogn)
 * space:O(logn)
 */
int MaximumSubarray::maxSubArray4(vector<int>& nums) {
	return divided(nums, 0, nums.size() - 1);
}

int MaximumSubarray::divided(vector<int>& nums, int left, int right) {
	if (left == right) {
		return nums[left];
	}
	int middle = (right - left) / 2 + left;

	// 左右子串的最大和
	int maxLeft = divided(nums, left, middle);
	int maxRight = divided(nums, middle + 1, right);

	// 横跨左右子串的最大和
	// 以中间元素结尾的左子串最大和
	int maxLeftBorder = nums[middle];
	int curSum = nums[middle];
	for (int i = middle - 1; i >= left; i--) {
		curSum += nums[i];
		maxLeftBorder = max(curSum, maxLeftBorder);
	}
	// 以中间元素开头的右子串最大和
	int maxRightBorder = nums[middle + 1];
	curSum = nums[middle + 1];
	for (int i = middle + 2; i <= right; i++) {
		curSum += nums[i];
		maxRightBorder = max(curSum, maxRightBorder);
	}

	return max({ maxLeft,maxRight,maxRightBorder + maxLeftBorder });
}
