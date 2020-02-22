#include "header/Sum4.h"

#include <algorithm>

using std::sort;

/**
 * https://leetcode.com/problems/4sum/
 */

 /**
  * 每次先确定两个数，再用双指针，类似3sum中的解法
  * time:O(n^3)
  * space:O(1)
  */
vector<vector<int>> Sum4::fourSum1(vector<int>& nums, int target) {
	int length = nums.size();
	vector<vector<int>> res;

	sort(nums.begin(), nums.end());

	for (int i = 0; i < length - 3; i++) {

		// 防止重复
		if (i > 0 && nums.at(i) == nums.at(i - 1)) {
			continue;
		}

		for (int j = i + 1; j < length - 2; j++) {

			// 防止重复
			if (j > i + 1 && nums.at(j) == nums.at(j - 1)) {
				continue;
			}

			int left = j + 1;
			int right = length - 1;
			while (left < right) {

				// 防止重复
				if (left > j + 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				if (right < length - 1 && nums[right] == nums[right + 1]) {
					right--;
					continue;
				}

				int sum = nums.at(i) + nums.at(j) + nums.at(left) + nums.at(right);
				if (sum == target) {
					res.push_back({ nums.at(i) , nums.at(j) , nums.at(left) , nums.at(right) });
					left++;
					right--;
				} else if (sum < target) {
					left++;
				} else if (sum > target) {
					right--;
				}
			}
		}
	}

	return res;
}
