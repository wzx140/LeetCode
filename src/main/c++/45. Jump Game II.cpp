#include "Header.h"

#include <vector>
#include <queue>
#include <map>
#include <cmath>

using std::pair;
using std::make_pair;
using std::vector;
using std::queue;
using std::max;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */

 /**
  * bfs
  * time:O(n)
  * space:O(n)
  */
int JumpGame2::jump1(vector<int>& nums) {
	int des = nums.size() - 1;

	queue<pair<int, int>> open;
	open.push(make_pair(0, 0));
	// 上一跳，所能到达的最远距离
	int last = 0;
	while (!open.empty()) {
		int index = open.front().first;
		int step = open.front().second;
		open.pop();

		if (index >= des) {
			return step;
		}

		// 所有在上一跳所能到达的最远距离内的跳跃都不必要做
		int cur = last - index;
		for (int i = nums[index]; i > cur; i--) {
			open.push(make_pair(index + i, step + 1));
		}
		last = nums[index] + index;
	}

	return 0;
}

/**
 * https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 * time:O(n)
 * space:O(1)
 */
int JumpGame2::jump2(vector<int>& nums) {
	int step = 0;
	// 上一次所能到达的最大范围
	int last = 0;
	// 当前所能到达的最大范围
	int cur = 0;
	int length = nums.size();

	for (int i = 0; i < length - 1; i++) {
		if (i > last) {
			step++;
			last = cur;
		}
		cur = max(cur, i + nums[i]);
		if (cur >= length - 1) {
			// 执行最后一跳到达终点
			return step + 1;
		}
	}
	// 单一元素的集合
	return 0;
}