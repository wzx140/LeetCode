#include "header/ContainerWithMostWater.h"

#include <algorithm>

using std::min;
using std::max;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */

 /**
  * 遍历所有可能，超出时间限制
  * time:O(n2)
  * space:O(1)
  */
int ContainerWithMostWater::maxArea1(vector<int>& height) {

	int maxWater = 0;

	int length = height.size();
	for (int i = 0; i < length - 1; i++) {
		for (int j = i + 1; j < length; j++) {
			int width = j - i;
			int cHeight = min(height.at(i), height.at(j));

			maxWater = max(width*cHeight, maxWater);
		}
	}

	return maxWater;
}

/**
 * 双指针
 * time:O(n)
 * space:O(1)
 */
int ContainerWithMostWater::maxArea2(vector<int>& height) {

	int length = height.size();
	int left = 0;
	int right = length - 1;
	int maxWater = 0;

	while (left < right) {
		int width = right - left;

		// 高度由left与right中较小的决定
		if (height.at(right) > height.at(left)) {
			maxWater = max(width*height.at(left), maxWater);

			// 无论right左移多少，此时永远是最大，所以不用比较，直接left右移
			left++;

		} else {
			maxWater = max(width*height.at(right), maxWater);

			// 无论left右移多少，此时永远是最大，所以不用比较，直接right左移
			right--;

		}
	}

	return maxWater;
}
