#include "Header.h"

#include <algorithm>
#include <limits>

using std::sort;
using std::numeric_limits;

/**
 * https://leetcode.com/problems/next-permutation/
 */

 /**
  * lexicographically: 字典序
  * https://zh.wikipedia.org/zh-hans/%E5%AD%97%E5%85%B8%E5%BA%8F
  */

  /**
   * 题目要求原地算法，只能开辟常数阶的额外空间
   * time:O(n2)
   * space:O(1)
   */
void NextPermutation::nextPermutation1(vector<int>& nums) {
	int length = nums.size();

	// 从倒数第二位开始遍历
	// i被交换位,nums[i]较小,swapped
	// j交换位,nums[j]较大,swapt
	int swapped = -1;
	int swapt = -1;
	for (int i = length - 2; i >= 0; i--) {

		// 在其之后位寻找,是否存在比其大一点的数字
		int distance = numeric_limits<int>::max();
		for (int j = i + 1; j < length; j++) {
			int diff = nums.at(j) - nums.at(i);

			// 寻找与被交换位差值最小的数
			if (diff > 0 && diff < distance) {
				distance = diff;
				swapped = i;
				swapt = j;
			}
		}


		if (distance < numeric_limits<int>::max()) {

			// 交换
			int temp = nums.at(swapped);
			nums[swapped] = nums.at(swapt);
			nums[swapt] = temp;

			// 对被交换位之后的数进行排序
			sort(nums.begin() + swapped + 1, nums.end());
			return;
		}
	}

	// 找不到字典序更大的排列
	sort(nums.begin(), nums.end());
}

/**
 * 对上一个方法的改进
 * time:O(n)
 * space:O(1)
 */
void NextPermutation::nextPermutation2(vector<int>& nums) {
	int length = nums.size();

	// swapped被交换位
	// swapt交换位
	int swapped = length - 2;
	int swapt = length - 1;

	// 从后往前找到开始降序的第一个索引,即为被交换位
	// 只需比较相邻两个数即可
	while (swapped >= 0 && nums.at(swapped) >= nums.at(swapped + 1)) {
		swapped--;
	}

	if (swapped >= 0) {

		// 在被交换位之后寻找交换位
		// 由于上一个循环可以交换位之后的数是降序排列的
		// 只需从后往前遍历寻找大于交换位的数
		while (swapt >= 0 && nums.at(swapt) <= nums.at(swapped)) {
			swapt--;
		}

		// 交换
		int temp = nums.at(swapped);
		nums[swapped] = nums.at(swapt);
		nums[swapt] = temp;

		// 对被交换位之后的数进行排序
		sort(nums.begin() + swapped + 1, nums.end());
		
	} else {
		// 找不到字典序更大的排列
		sort(nums.begin(), nums.end());
	}
}