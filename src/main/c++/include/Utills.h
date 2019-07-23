#pragma once
#include <vector>
#include <iostream>

using std::cout;
using std::endl;
using std::vector;

namespace demonstrate{
	inline void printMatrix(vector<vector<int>> &matrix){
		for(int i=0; i<matrix.size(); i++){
			for(int j = 0; j < matrix[i].size(); j++) {
				cout << matrix[i][j] << ' ';
			}
			cout<<endl;
		}
		cout << endl;
	}
	inline void printVector(vector<int> &nums){
		for(int i=0; i<nums.size(); i++){
			cout << nums[i] << ' ';
		}
		cout << endl;
	}
}

namespace search{

	inline int binarySearch(int begin, int end, vector<int> &nums, int target){
		int res = -1;
		while (begin <= end){
			int middle = begin + (end - begin);
			if(nums[middle] > target){
				end = middle - 1;
			}else if(nums[middle] < target){
				begin = middle + 1;
			}else if(nums[middle] == target){
				res = middle;
				break;
			}
		}
		return res;
	}
}

