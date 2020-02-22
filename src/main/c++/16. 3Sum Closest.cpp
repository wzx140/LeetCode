#include "header/Sum3Closest.h"

#include <algorithm>

using std::sort;
using std::min;

/**
 * https://leetcode.com/problems/3sum-closest/
 */

 /**
  * 与 3sum 类似
  * time:O(n^2)
  * space:O(1)
  */
int Sum3Closest::threeSumClosest1(vector<int>& nums, int target) {

	int length = nums.size();
	int sum = nums.at(0) + nums.at(1) + nums.at(2);

	sort(nums.begin(), nums.end());

	for (int i = 0; i < length - 2; i++) {

		if (i > 0 && nums.at(i - 1) == nums.at(i)) {
			continue;
		}

		int left = i + 1;
		int right = length - 1;
		while (left < right) {
			if (left > i + 1 && nums.at(left - 1) == nums.at(left)) {
				left++;
				continue;
			}
			if (right < length - 1 && nums.at(right + 1) == nums.at(right)) {
				right--;
				continue;
			}

			int tempSum = nums.at(i) + nums.at(left) + nums.at(right);
			if (abs(tempSum - target) < abs(sum - target)) {
				sum = tempSum;
			}

			if (tempSum > target) {
				right--;
			} else if (tempSum < target) {
				left++;
			} else {
				return target;
			}
		}
	}

	return sum;
}
