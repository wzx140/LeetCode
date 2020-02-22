#pragma once
#include <vector>

using std::vector;

class MaximumSubarray {
public:
	int maxSubArray1(vector<int>& nums);
	int maxSubArray2(vector<int>& nums);
	int maxSubArray3(vector<int>& nums);
	int maxSubArray4(vector<int>& nums);
	int divided(vector<int>& nums, int left, int right);
};
