#include "header/CoinChange.h"

#include <algorithm>

using std::min;

/**
 * https://leetcode.com/problems/coin-change/
 */

 /**
  * 最小硬币数
  */
int minNum = 0;
/**
 * 硬币种类
 */
int len = 0;


/**
 * 回溯，遍历所有可能的结果，找出最小值
 * 自顶向下
 * time:O(k*n^k)
 * space:O(n)
 */
int CoinChange::coinChange1(vector<int>& coins, int amount) {
	minNum = amount + 1;
	len = coins.size();
	backtrack(coins, amount, 0);
	return minNum == amount + 1 ? -1 : minNum;
}

void CoinChange::backtrack(vector<int>& coins, int amount, int num) {
	if (amount == 0) {
		minNum = min(num, minNum);
		return;
	}
	if (amount < 0) {
		return;
	}

	for (int i = 0; i < len; i++) {
		amount -= coins[i];
		num++;
		backtrack(coins, amount, num);
		amount += coins[i];
		num--;
	}
}


/**
 * 递归，分解子问题
 * 自顶向下
 * time:O(kn)
 * space:O(n)
 */
int CoinChange::coinChange2(vector<int>& coins, int amount) {
	len = coins.size();
	map<int, int> cache;
	return recursive(coins, amount, cache);
}

int CoinChange::recursive(vector<int>& coins, int amount, map<int, int>& cache) {
	if (amount == 0) {
		return 0;
	}
	if (amount < 0) {
		return -1;
	}
	if (cache.find(amount) != cache.end()) {
		return cache[amount];
	}

	int minNum = amount + 1;
	for (int i = 0; i < len; i++) {
		// 分解子问题
		int sub = recursive(coins, amount - coins[i], cache);
		if (sub == -1) {
			continue;
		}
		minNum = min(minNum, sub + 1);
	}
	minNum == amount + 1 ? cache[amount] = -1 : cache[amount] = minNum;

	return cache[amount];
}

/**
 * 动态规划
 * 自底向上
 * time:O(kn)
 * space:O(k)
 */
int CoinChange::coinChange3(vector<int>& coins, int amount) {
	vector<int> dp(amount + 1, amount + 1);
	dp[0] = 0;
	len = coins.size();

	for (int i = 1; i <= amount; i++) {
		for (int j = 0; j < len; j++) {
			if (coins[j] > i) {
				continue;
			}
			dp[i] = min(dp[i], dp[i - coins[j]] + 1);
		}
	}

	return dp[amount] > amount ? -1 : dp[amount];
}