#include "Header.h"
#include <limits>
#include <algorithm>

// find the middle two elements
double MedianOfTwoSortedArrays::findMedianSortedArrays1(vector<int>& nums1, vector<int>& nums2){
	int length1 = nums1.size();
	int length2 = nums2.size();
	int length = length1 + length2;

	// save the middle two elements
	int middle1 = 0;
	int middle2 = 0;

	int i = 0;
	int j = 0;
	int count = 0;
	while(count <= length / 2){
		// prevent overflow
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

// use binary search
double MedianOfTwoSortedArrays::findMedianSortedArrays2(vector<int>& nums1, vector<int>& nums2){
	if(nums1.size() > nums2.size()){
		std::swap(nums1, nums2);
	}

	int length1 = nums1.size();
	int length2 = nums2.size();

	//  The length of the smaller length array is zero
	if(length1 == 0){
		return length2 % 2 ? nums2[length2 / 2] : (nums2[length2 / 2] + nums2[length2 / 2 - 1]) / 2.0;
	}

	int i = 0;
	int j = 0;

	int left = 0;
	// i search in 0~length1 not in 0~length1-1
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

	// special boundary condition
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