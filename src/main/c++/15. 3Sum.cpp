#include "Header.h"

#include <algorithm>
#include <map>

using std::map;
using std::sort;

/**
 * https://leetcode.com/problems/3sum/
 */

 /** 判断是否重复，两个元素一样即为重复 */
bool isDuplication(int num1, int num2, vector<vector<int>>& nums) {
	if (num1 != num2) {
		for (const auto& item : nums) {
			if (find(item.begin(), item.end(), num1) != item.end() && find(item.begin(), item.end(), num2) != item.end()) {
				return true;
			}
		}
	} else {
		for (const auto& item : nums) {
			if (count(item.begin(), item.end(), num1) >= 2) {
				return true;
			}
		}
	}
	return false;
}

/**
 * 每次先确定两个数，再用哈希表查找第三个数，超出时间限制，原因是有很多重复判断的情况
 * time:O(n^2)
 * space:O(n)
 */
vector<vector<int>> Sum3::threeSum1(vector<int>& nums) {
	int length = nums.size();
	vector<vector<int>> solutions;

	// 值 - 索引
	map<int, int> hashMap;
	for (int i = 0; i < nums.size(); i++) {
		hashMap[nums[i]] = i;
	}

	for (int i = 0; i < length - 1; i++) {
		for (int j = i + 1; j < length; j++) {

			// 目标数
			int dest = -(nums.at(i) + nums.at(j));

			// 哈希表搜索
			map<int, int>::iterator it = hashMap.find(dest);
			if (it != hashMap.end() && it->second != i && it->second != j && !isDuplication(nums.at(i), nums.at(j), solutions)) {
				solutions.push_back({ it->first ,nums.at(j),nums.at(i) });
			}
		}
	}

	return solutions;
}

/**
 * 每次先确定一个数，用双指针查找剩下的数（排序后）,难点是判断重复
 * time:O(n^2)
 * space:O(1)
 */
vector<vector<int>> Sum3::threeSum2(vector<int>& nums) {

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