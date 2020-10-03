#include "header/SuperEggDrop.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::max;
using std::min;

/**
 * https://leetcode.com/problems/super-egg-drop/
 */

 /**
  * 动态规划，这里只给出自底向上的动态规划解法
  * dp[n][k]：n:剩余未测楼层；k:剩余鸡蛋；测试的次数
  * k=1：dp[n][k]=n，只剩一个鸡蛋，只能按顺序测试
  * 第i层扔鸡蛋：dp[n][k]=min_i{max(dp[i-1][k],dp[n-i][k-1])+1}，求最坏情况(with certainty)所以取最大值
  */

  /**
   * 动态规划，超时了
   * time:O(KN^2)
   * space:O(NK)
   */
int SuperEggDrop::superEggDrop1(int K, int N) {
	// n:0~N：剩余1~N个楼层，0表示只剩下第0层
	// k:0~K-1:剩余1~K个鸡蛋
	vector<vector<int>> dp(N + 1, vector<int>(K, N));
	for (int i = 0; i <= N; i++) {
		// 只剩一个鸡蛋，只能从下往上慢慢试
		dp[i][0] = i;
	}
	for (int i = 0; i < K; i++) {
		dp[0][i] = 0;
	}

	for (int n = 1; n <= N; n++) {
		for (int k = 1; k < K; k++) {
			// 每个状态都尝试从剩余楼层中的第i层扔鸡蛋
			for (int i = 1; i <= n; i++) {
				// 碎与没碎
				int opNum = max(dp[n - i][k - 1], dp[i - 1][k]) + 1;
				// 取最小的那一层
				dp[n][k] = min(dp[n][k], opNum);
			}
		}
	}

	return dp[N][K - 1];
}