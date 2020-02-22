#include "Header.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::min;

/**
 * https://leetcode.com/problems/jump-game/
 */

 /**
  * 在深搜的同时，记录当前位置有没有被跳过
  * time:O(n)
  * space:O(n)
  */
bool JumpGame::canJump1(vector<int>& nums) {
	int len = nums.size();
	vector<int> jumped(len, 0);
	return dfs(nums, jumped, 0, len);
}

bool JumpGame::dfs(vector<int>& nums, vector<int>& jumped, int pos, int len) {
	if (pos == len - 1) {
		return true;
	}

	int maxJump = min(pos + nums[pos], len - 1);
	for (int next = maxJump; next > pos; next--) {
		// 跳过已经去过的地方
		if (jumped[next] == 1) {
			continue;
		}
		jumped[next] = 1;
		if (dfs(nums, jumped, next, len)) {
			return true;
		}
	}
	return false;
}

/**
 * 动态规划
 * time:O(n)
 * space:O(n)
 */
bool JumpGame::canJump2(vector<int>& nums) {
	int len = nums.size();
	vector<int> dp(len, 0);
	dp[len - 1] = true;

	// 从右往左
	for (int i = len - 2; i >= 0; i--) {
		int maxJump = min(i + nums[i], len - 1);
		for (int next = i + 1; next <= maxJump; next++) {
			// dp[i] = dp[i+jump]
			if (dp[next] == 1) {
				dp[i] = 1;
				break;
			}
		}
	}

	return dp[0];
}

/**
 * 贪心
 * time:O(n)
 * space:O(1)
 */
bool JumpGame::canJump3(vector<int>& nums) {
	int len = nums.size();
	// 上一次可以跳到终点的位置
	int lastPos = len - 1;

	// 从右往左
	for (int i = len - 2; i >= 0; i--) {
		int maxJump = i + nums[i];
		for (int next = i + 1; next <= maxJump; next++) {
			if (next >= lastPos) {
				lastPos = i;
				break;
			}
		}
	}

	return lastPos == 0;
}