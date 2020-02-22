#include "header/RDSA.h"

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

 /**
  * 每次迭代比较相邻两个数，若相等就将之后的数循环前移
  * time:O(n2)
  * space:O(1)
  */
int RDSA::removeDuplicates1(vector<int>& nums) {
	int length = nums.size();

	if (length == 1) {
		return length;
	}

	for (int i = 1; i < length; i++) {

		if (nums.at(i) == nums.at(i - 1)) {

			length--;

			// 循环前移
			for (int j = i - 1; j < length; j++) {
				nums[j] = nums.at(j + 1);
			}
			i--;
		}
	}

	return length;
}

/**
 * 双指针
 * time:O(n)
 * space:O(1)
 */
int RDSA::removeDuplicates2(vector<int>& nums) {
	int length = nums.size();

	if (length == 0) {
		return length;
	}

	int storeIndex = 0;
	int cursor = 0;

	while (cursor < length) {
		if (nums.at(storeIndex) == nums.at(cursor)) {
			cursor++;
		} else {
			nums[++storeIndex] = nums.at(cursor++);
		}

	}

	return storeIndex + 1;
}
