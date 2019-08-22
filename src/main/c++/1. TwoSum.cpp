#include <iostream>
#include <vector>
#include <map>
#include <iostream>

using std::vector;
using std::map;

/**
 * https://leetcode.com/problems/two-sum/
 */

// 暴力法 time:O(n2) space:O(1)
vector<int> twoSum1(vector<int>& nums, int target) {
	vector<int> res;
	for (int i = 0; i < nums.size() - 1; i++) {
		for (int j = i + 1; j < nums.size(); j++) {
			if (nums[i] + nums[j] == target) {
				res.push_back(i);
				res.push_back(j);
				return res;
			}
		}
	}
	return res;
}


// 哈希表 time:O(n) space:O(n)
vector<int> twoSum2(vector<int>& nums, int target) {
	vector<int> res;
	// 值 - 索引
	map<int, int> hashMap;
	for (int i = 0; i < nums.size(); i++) {
		hashMap[nums[i]] = i;
	}

	for (int i = 0; i < nums.size(); i++) {
		map<int, int>::iterator it = hashMap.find(target - nums[i]);
		if (it != hashMap.end() && it->second != i) {
			res.push_back(i);
			res.push_back(it->second);
			break;
		}
	}
	return res;
}


// 哈希表，只使用一个循环 time:O(n) space:O(n)
vector<int> twoSum3(vector<int>& nums, int target) {
	vector<int> res;
	// 值 - 索引
	map<int, int> hashMap;

	for (int i = 0; i < nums.size(); i++) {
		map<int, int>::iterator it = hashMap.find(target - nums[i]);
		if (it != hashMap.end()) {
			res.push_back(i);
			res.push_back(it->second);
			break;
		} else {
			// 两个值的和为定值是相互成立的
			hashMap[nums[i]] = i;
		}
	}
	return res;
}
