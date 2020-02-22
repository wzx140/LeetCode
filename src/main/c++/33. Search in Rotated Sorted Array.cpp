#include "header/SRSA.h"

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

 /**
  * 先找到原起点，再对两部分分别使用二分搜索
  * time:O(logn)
  * space:O(1)
  */
int SRSA::search1(vector<int>& nums, int target) {
	int length = nums.size();

	int left = 0;
	int right = length - 1;
	int rotate = 0;
	// 第二个条件防止middle跑到数组尾部
	while (left <= right && left + right < 2 * length - 2) {
		int middle = (right + left) / 2;

		// middle右边一位是原起点
		if (nums.at(middle) > nums.at(middle + 1)) {
			rotate = middle + 1;
			break;

			// 原起点在middle左部
		} else if (nums.at(left) > nums.at(middle)) {
			right = middle - 1;

			// 原起点在middle右部
		} else {
			left = middle + 1;
		}
	}

	// 对左部使用二分搜索
	int lLeft = 0;
	int lRight = rotate - 1;
	while (lLeft <= lRight) {
		int middle = (lRight + lLeft) / 2;

		if (target > nums.at(middle)) {
			lLeft = middle + 1;
		} else if (target < nums.at(middle)) {
			lRight = middle - 1;
		} else {
			return middle;
		}
	}

	// 对右部使用二分搜索
	int rLeft = rotate;
	int rRight = length - 1;
	while (rLeft <= rRight) {
		int middle = (rLeft + rRight) / 2;

		if (target > nums.at(middle)) {
			rLeft = middle + 1;
		} else if (target < nums.at(middle)) {
			rRight = middle - 1;
		} else {
			return middle;
		}
	}

	return -1;
}

/**
 * 只使用一次二分搜索
 * time:O(logn)
 * space:O(1)
 */
int SRSA::search2(vector<int>& nums, int target) {
	int length = nums.size();

	int left = 0;
	int right = length - 1;
	while (left <= right) {
		int middle = (left + right) / 2;

		if (target == nums.at(middle)) {
			return middle;
		}

		// 左部是升序(右部非升序),target比left小,或者target比middle大时,target应存在右部
		if (nums.at(left) <= nums.at(middle) &&
			(target < nums.at(left) || target > nums.at(middle))) {

			left = middle + 1;

			// 左部非升序(右部分升序),target在middle和right之间,target应该存在右部
		} else if (nums.at(left) > nums.at(middle) &&
			(target <= nums.at(right) && target > nums.at(middle))) {

			left = middle + 1;

		} else {
			right = middle - 1;
		}
	}

	return -1;
}
