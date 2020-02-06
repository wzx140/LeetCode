#include "Header.h"

#include <vector>
#include <algorithm>
#include <cmath>

using std::vector;
using std::sort;
using std::abs;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */

 /**
  * 先排序，再用第34的二分搜索找到最接近于1的下界i
  * 如果i处的值不为1，说明最小正数为1
  * 如果i处的值为1，则向后遍历寻找不连续的断层
  * time:O(n)
  * space:O(1)
  */
int FirstMissingPositive::firstMissingPositive1(vector<int>& nums) {

	if (nums.empty()) {
		return 1;
	}

	sort(nums.begin(), nums.end());

	// 二分搜索找到最小的正数
	int begin = 0;
	int end = nums.size() - 1;
	while (begin < end) {
		int middle = (end - begin) / 2 + begin;

		if (nums[middle] >= 1) {
			end = middle;
		} else {
			begin = middle + 1;
		}
	}

	if (nums[begin] != 1) {
		return 1;
	}
	for (int i = begin + 1; i < nums.size(); i++) {
		// 找到非连续或非重复的断层
		if (nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1) {
			return nums[i - 1] + 1;
		}
	}
	return nums.back() + 1;
}

/**
 * https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
 * time:O(n)
 * space:O(1)
 */
int FirstMissingPositive::firstMissingPositive2(vector<int>& nums) {
	// 1的存在性
	int flag = false;
	for (int i = 0; i < nums.size(); i++) {
		if (nums[i] == 1) {
			flag = true;
			break;
		}
	}
	if (!flag) {
		return 1;
	}

	// 将小于1，大于数组长度的数置1
	for (int i = 0; i < nums.size(); i++) {
		if (nums[i] <= 0 || nums[i] > nums.size()) {
			nums[i] = 1;
		}
	}

	// 将bitmap与原数组融合在一起
	for (int i = 0; i < nums.size(); i++) {
		int value = abs(nums[i]);
		if (nums[value - 1] > 0) {
			nums[value - 1] = -nums[value - 1];
		}
	}

	for (int i = 0; i < nums.size(); i++) {
		if (nums[i] > 0) {
			return i + 1;
		}
	}
	return nums.size() + 1;
}
