#include "header/MNABB.h"

#include <algorithm>

using std::sort;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */

 /**
  * 贪心，类似435. non-overlapping-intervals
  * time:O(n)
  * space:O(1)
  */
int MNABB::findMinArrowShots1(vector<vector<int>>& points) {
	if (points.empty()) {
		return 0;
	}

	sort(points.begin(), points.end(), compare);
	int count = 1, len = points.size();
	int lastEnd = points[0][1];

	for (int i = 1; i < len; i++) {
		if (points[i][0] > lastEnd) {
			lastEnd = points[i][1];
			count++;
		}
	}
	return count;
}
bool MNABB::compare(const vector<int> &v1, const vector<int> &v2) {
	return v1[1] < v2[1];
}