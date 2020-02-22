#include "header/SearchInsertPosition.h"

#include <vector>

using std::vector;

/**
 * https://leetcode.com/problems/search-insert-position/
 */

 /**
  * 二分搜索
  * time:O(logn)
  * space:O(1)
  */
int SearchInsertPosition::searchInsert1(vector<int>& nums, int target) {
	int begin = 0, end = nums.size() - 1, middle = 0, pos = 0;
	while (begin <= end) {
		middle = (end - begin) / 2 + begin;
		if (nums[middle] == target) {
			return middle;
		} else if (nums[middle] > target) {
			end = middle - 1;
			pos = middle;
		} else {
			begin = middle + 1;
			pos = begin;
		}
	}

	return pos == -1 ? 0 : begin;
}
