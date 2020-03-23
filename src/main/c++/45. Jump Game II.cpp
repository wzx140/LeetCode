#include "header/JumpGame2.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::min;
using std::max;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */

 /**
  * dp[i]:从i跳到终点的跳步数
  * i处单次跳跃到达的范围内的点更新dp[i]
  * 递推公式：for j in (i, i+nums[i]): dp[i]=min(dp[i],dp[j]+1);
  */

  /**
   * 动态规划，超时
   * time:O(n^2)
   * space:O(n)
   */
int JumpGame2::jump1(vector<int>& nums) {
	int len = nums.size();
	vector<int> dp(len, len);
	dp[len - 1] = 0;

	for (int i = len - 2; i >= 0; i--) {
		for (int step = 1; step <= nums[i]; step++) {
			if (i + step < len) {
				dp[i] = min(dp[i], dp[i + step] + 1);
			}
		}
	}

	return dp[0];
}

/**
 * https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 * time:O(n)
 * space:O(1)
 */
int JumpGame2::jump2(vector<int>& nums) {
	int len = nums.size();
	int farthest = 0;
	// 上一跳的最远距离
	int end = 0;
	int jumps = 0;
	for (int i = 0; i < len - 1; i++) {
		// 每次选择跳到的最远距离
		farthest = max(farthest, i + nums[i]);

		// 如果上一跳只能到达这里，只能开启下一条
		if (end == i) {
			jumps++;
			end = farthest;
		}
	}
	return jumps;
}
