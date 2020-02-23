#include "header/MergeIntervals.h"

#include <algorithm>

using std::sort;
using std::max;

/**
 * https://leetcode.com/problems/merge-intervals/
 */

 /**
  *
  * time:O(n)
  * space::O(n)
  */
vector<vector<int>> MergeIntervals::merge1(vector<vector<int>>& intervals) {
	int len = intervals.size();
	vector<vector<int>> res;
	if (len == 0) {
		return res;
	}

	sort(intervals.begin(), intervals.end());

	int lastLeft = intervals[0][0];
	int lastRight = intervals[0][1];
	for (int i = 1; i < len; i++) {
		int left = intervals[i][0];
		int right = intervals[i][1];

		if (lastRight >= left) {
			left = lastLeft;
			right = max(lastRight, right);
		} else {
			res.push_back({ lastLeft,lastRight });
		}
		lastLeft = left, lastRight = right;
	}

	if (res.empty() || res.back()[1] != lastRight) {
		res.push_back({ lastLeft,lastRight });
	}
	return res;
}
