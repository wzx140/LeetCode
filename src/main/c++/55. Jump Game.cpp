#include "header/JumpGame.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::min;
using std::max;

/**
 * https://leetcode.com/problems/jump-game/
 */

/**
 * dp[i]:能否从i位置跳到终点
 * i处单次跳跃到达的范围内的点是否能到达终点
 * 递推公式：for j in (i, i+nums[i]): if(dp[j]){dp[i]=true;break;}
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
	int n = nums.size();
	int farthest = 0;
	for (int i = 0; i < n - 1; i++) {
		// 不能跳到该位置
		if (farthest < i) {
			return false;
		}

		// 不断计算能跳到的最远距离
		farthest = max(farthest, i + nums[i]);
	}
	return farthest >= n - 1;
}
