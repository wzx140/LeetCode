#include "header/FFLP.h"

#include <vector>
#include <cmath>

using std::vector;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

 /**
  * https://masterwangzx.com/2020/03/03/binary-search/
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
	int start = 0;
	int end = length;
	while (start < end) {
		int middle = (end - start) / 2 + start;
		if (nums[middle] >= target) {
			end = middle;
		} else {
			start = middle + 1;
		}
	}
	if (start < length && nums[start] == target) {
		lowerBound = start;
	}

	// 寻找上界
	start = 0;
	end = length - 1;
	while (start <= end) {
		int middle = (end - start) / 2 + start;
		if (nums[middle] <= target) {
			start = middle + 1;
		} else {
			end = middle - 1;
		}
	}
	if (end >= 0 && nums[end] == target) {
		upperBound = end;
	}

	return { lowerBound,upperBound };
}
