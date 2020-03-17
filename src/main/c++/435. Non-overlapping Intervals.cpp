#include "header/NonOverlappingIntervals.h"

#include <algorithm>
#include <limits>

using std::numeric_limits;
using std::sort;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */

 /**
  * 贪心
  * 1. 从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
  * 2. 把所有与 x 区间相交的区间从区间集合 intvs 中删除。
  * 3. 重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
  * time:O(n)
  * space:O(1)
  */
int NonOverlappingIntervals::eraseOverlapIntervals1(vector<vector<int>>& intervals) {

	if(intervals.empty()){
		return 0;
	}

	sort(intervals.begin(), intervals.end(), compare);
	int count = 0, len = intervals.size();
	int lastEnd = intervals[0][1];

	for (int i = 1; i < len; i++) {
		if (intervals[i][0] < lastEnd) {
			count++;
		} else {
			lastEnd = intervals[i][1];
		}
	}
	return count;
}
bool NonOverlappingIntervals::compare(const vector<int> &v1, const vector<int> &v2) {
	return v1[1] < v2[1];
}
