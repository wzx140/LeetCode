#include "Header.h"
#include <limits>
#include <algorithm>

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

// 找出数组中间的两个值 time:O(m+n) space:O(1)
double MedianOfTwoSortedArrays::findMedianSortedArrays1(vector<int>& nums1, vector<int>& nums2){
	int length1 = nums1.size();
	int length2 = nums2.size();
	int length = length1 + length2;

	// 中间的两个元素
	int middle1 = 0;
	int middle2 = 0;

	int i = 0;
	int j = 0;
	int count = 0;
	while(count <= length / 2){
		// 初始化为最大值
		int num1 = std::numeric_limits<int>::max();
		int num2 = std::numeric_limits<int>::max();
		if(i < length1){
			num1 = nums1[i];
		}
		if(j < length2){
			num2 = nums2[j];
		}

		if(num1 < num2){
			i++;
			if((count + 1) % 2 == 0){
				middle2 = num1;
			} else{
				middle1 = num1;
			}
		} else{
			j++;
			if((count + 1) % 2 == 0){
				middle2 = num2;
			} else{
				middle1 = num2;
			}
		}

		count++;
	}

	if(length % 2 == 0){
		return (middle1 + middle2) / 2.0;
	} else{
		return std::max(middle1, middle2);
	}

}

// 使用二分搜索  time:O(log(m+n) space:O(1)
double MedianOfTwoSortedArrays::findMedianSortedArrays2(vector<int>& nums1, vector<int>& nums2){
	if(nums1.size() > nums2.size()){
		std::swap(nums1, nums2);
	}

	int length1 = nums1.size();
	int length2 = nums2.size();

	//  较小的长度为0的情况
	if(length1 == 0){
		return length2 % 2 ? nums2[length2 / 2] : (nums2[length2 / 2] + nums2[length2 / 2 - 1]) / 2.0;
	}

	int i = 0;
	int j = 0;

	int left = 0;
	// i在0~length1中搜索，而不是0~length1-1
	int right = length1;
	int delta = (length1 + length2 + 1) / 2;
	while(left <= right){
		i = left + (right - left) / 2;
		j = delta - i;
		if(i < length1 && nums1[i] < nums2[j - 1]){
			left = i + 1;
		} else if(j < length2 && nums1[i - 1] > nums2[j]){
			right = i - 1;
		} else{
			break;
		}
	}

	// 边界条件
	int maxLeft = 0;
	if(i == 0){
		maxLeft = nums2[j - 1];
	} else if(j == 0){
		maxLeft = nums1[i - 1];
	} else{
		maxLeft = std::max(nums1[i - 1], nums2[j - 1]);
	}

	int minRight = 0;
	if(i == length1){
		minRight = nums2[j];
	} else if(j == length2){
		minRight = nums1[i];
	} else{
		minRight = std::min(nums1[i], nums2[j]);
	}

	if((length1 + length2) % 2 == 1){
		return maxLeft;
	} else{
		return (maxLeft + minRight) / 2.0;
	}
}