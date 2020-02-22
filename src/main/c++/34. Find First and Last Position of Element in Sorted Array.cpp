#include "header/FFLP.h"

#include <vector>
#include <cmath>

using std::vector;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

 /**
  * 先用二分搜索找最左端元素，再向右寻找到最右端元素
  * time:O(logn)
  * space:O(1)
  */
vector<int> FFLP::searchRange1(vector<int>& nums, int target) {

	int length = nums.size();
	if (length == 0) {
		return { -1,-1 };
	}

	int upperBound = -1;
	int lowerBound = -1;

	// 寻找下界
	int begin = 0;
	int end = length - 1;
	while (begin < end) {
		int middle = (end - begin) / 2 + begin;

		if (nums[middle] >= target) {
			end = middle;
		} else {
			begin = middle + 1;
		}
	}
	lowerBound = begin;

	if (begin > length - 1 || nums[begin] != target) {
		return { -1,-1 };
	}

	// 寻找上界
	end = length - 1;
	while (begin < end) {
		int middle = ceil((end - begin) / 2. + begin);

		if (nums[middle] > target) {
			end = middle - 1;
		} else {
			begin = middle;
		}
	}
	upperBound = end;

	return { lowerBound,upperBound };
}
