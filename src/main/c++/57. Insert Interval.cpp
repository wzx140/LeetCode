#include "header/InsertInterval.h"

#include <algorithm>

using std::max;

/**
 * https://leetcode.com/problems/insert-interval/
 */

 /**
  *
  * time:O(n)
  * space:O(1)
  */
vector<vector<int>> InsertInterval::insert1(vector<vector<int>>& intervals, vector<int>& newInterval) {
	if (intervals.empty()) {
		return { newInterval };
	}

	int len = intervals.size();
	// 二分找到需要合并的起始点(下界)
	int begin = 0, end = len - 1, middle = 0;
	int target = newInterval[0];
	while (begin < end) {
		middle = (end - begin) / 2 + begin;
		if (intervals[middle][0] < target) {
			begin = middle + 1;
		} else {
			end = middle;
		}
	}
	if (intervals[begin][0] >= target) {
		begin--;
	}

	// 类似56题的解法
	int lastLeft = 0, lastRight = 0;
	int left = 0, right = 0;
	int cur = begin;
	// 没有找到比插入元素更小的元素
	if (begin == -1) {
		begin++;
		lastLeft = newInterval[0], lastRight = newInterval[1];
		left = intervals[begin][0], right = intervals[begin][1];
	} else {
		// 找到下界
		lastLeft = intervals[begin][0], lastRight = intervals[begin][1];
		left = newInterval[0], right = newInterval[1];
	}
	cur = begin;
	for (int i = begin; i < len; i++) {
		if (i != begin) {
			left = intervals[i][0];
			right = intervals[i][1];
		}

		if (lastRight >= left) {
			left = lastLeft;
			right = max(lastRight, right);
		} else {
			intervals[cur][0] = lastLeft;
			intervals[cur][1] = lastRight;
			cur++;
		}
		lastLeft = left, lastRight = right;
	}
	// 最后一个元素
	if (cur > len - 1) {
		intervals.push_back({ lastLeft,lastRight });
	} else {
		intervals[cur][0] = lastLeft;
		intervals[cur][1] = lastRight;
	}
	cur++;

	return vector<vector<int>>(intervals.begin(), intervals.begin() + cur);
}
