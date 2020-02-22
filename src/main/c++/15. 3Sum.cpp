#include "header/Sum3.h"

#include <algorithm>
#include <map>
#include <unordered_set>
#include <sstream>
#include <array>

using std::map;
using std::sort;
using std::unordered_set;
using std::stringstream;

/**
 * https://leetcode.com/problems/3sum/
 */

 /**
  * 由于可能存在重复元素，所以不能使用哈希搜索
  */


/**
 * 每次先确定一个数，用双指针查找剩下的数（排序后），注意判断重复
 * time:O(n^2)
 * space:O(1)
 */
vector<vector<int>> Sum3::threeSum1(vector<int>& nums) {

	int length = nums.size();
	vector<vector<int>> solutions;
	if (length < 3) {
		return solutions;
	}

	// 排序是为了双指针查找
	sort(nums.begin(), nums.end());

	for (int i = 0; i < length - 2; i++) {

		// 重复的nums[i]必然会导致重复
		if (i > 0 && nums[i] == nums[i - 1]) {
			continue;
		}

		// 在i的右边查找，仔细想想便知，在i左边查找的solution必然是重复的
		int left = i + 1;
		int right = length - 1;

		while (left < right) {

			// 双指针与前一次搜索位置的值一致，也会导致重复
			if (left > i + 1 && nums[left] == nums[left - 1]) {
				left++;
				continue;
			}
			if (right < length - 1 && nums[right] == nums[right + 1]) {
				right--;
				continue;
			}

			int res = nums.at(i) + nums.at(left) + nums.at(right);
			if (res == 0) {
				solutions.push_back({ nums.at(left) ,nums.at(right),nums.at(i) });
				left++;
				right--;
			} else if (res < 0) {
				// 值太小，left指针右移，增加值
				left++;
			} else if (res > 0) {
				// 值太大，right指针左移，减小值
				right--;
			}
		}
	}

	return solutions;
}
