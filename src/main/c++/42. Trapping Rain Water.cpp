#include "Header.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::min;
using std::max;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */

 /**
  * 从左向右寻找坑，左壁left，右壁right，满足以下任意一个条件：
  * 1. 满足right>=left，且right最靠近left
  * 2. 不存在right>=left，取left到末尾间最大的一个作为right
  * time:O(n^2)
  * space:O(1)
  */
int TrappingRainWater::trap1(vector<int>& height) {
	if (height.empty()) {
		return 0;
	}
	int left = 0;
	int right = 0;
	int water = 0;
	int length = height.size();

	// 从第一个非0项开始
	for (; right < length - 1; right++) {
		if (height[right] != 0) {
			break;
		}
	}

	while (right < length - 1) {
		left = right;
		// 寻找坑
		for (right = left + 1; right < length; right++) {
			if (height[right] >= height[left]) {
				break;
			}
		}
		if (right >= length) {
			int tmp = 0;
			for (int i = left + 1; i < length; i++) {
				if (height[i] >= tmp) {
					tmp = height[i];
					right = i;
				}
			}
		}

		// 统计蓄水量
		int scala = min(height[left], height[right]);
		for (int i = left + 1; i < right; i++) {
			water += scala - height[i];
		}
	}

	return water;
}

/**
 * 每个bar的蓄水量：左侧最高bar与右侧最高bar形成的水坑便是当前bar的蓄水量，min(left_max,right_max)-height[i]
 * 由于计算每个bar都需要算一次左侧与右侧最大值，所以一开始就遍历数组，计算出最大值数组
 * time:O(n)
 * space:O(n)
 */
int TrappingRainWater::trap2(vector<int>& height) {
	if (height.empty()) {
		return 0;
	}

	int length = height.size();
	vector<int> leftMax(length, height[0]);
	vector<int> rightMax(length, height.back());
	for (int i = 1; i < length; i++) {
		leftMax[i] = max(height[i], leftMax[i - 1]);
	}
	for (int i = length - 2; i >= 0; i--) {
		rightMax[i] = max(height[i], rightMax[i + 1]);
	}

	int water = 0;
	for (int i = 0; i < length; i++) {
		water += min(leftMax[i], rightMax[i]) - height[i];
	}

	return water;
}

/**
 * 双指针，上一种方法的改进
 * 当一侧指针指向较大的值时，会停滞，直到另一侧指向的值更大
 * 这就意味着，当前侧的最大值一定是两侧中最小的一个
 */
int TrappingRainWater::trap3(vector<int>& height) {
	int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
}
