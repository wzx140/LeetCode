#include <iostream>
#include <vector>
#include <map>
#include <iostream>

using std::vector;
using std::map;

vector<int> twoSum1(vector<int>& nums, int target){
	vector<int> res;
	for (int i=0; i<nums.size()-1; i++){
		for (int j = i+1; j < nums.size() ; j++){
			if(nums[i]+nums[j]==target){
				res.push_back(i);
				res.push_back(j);
				return res;
			}
		}
	}
	return res;
}

/**
 * hash table
 */
vector<int> twoSum2(vector<int>& nums, int target){
	vector<int> res;
	// value - index
	map<int, int> hashMap;
	for (int i = 0; i < nums.size() ; i++){
		hashMap[nums[i]] = i;
	}

	for (int i = 0; i < nums.size() ; i++){
		map<int, int>::iterator it = hashMap.find(target-nums[i]);
		if(it != hashMap.end() && it->second != i){
			res.push_back(i);
			res.push_back(it->second);
			break;
		}
	}
	return res;
}

/**
 * hash table in one pass
 * fix that "the same element can not be used twice"
 */
vector<int> twoSum3(vector<int>& nums, int target){
	vector<int> res;
	// value - index
	map<int, int> hashMap;

	for (int i = 0; i < nums.size() ; i++){
		map<int, int>::iterator it = hashMap.find(target-nums[i]);
		if(it != hashMap.end()){
			res.push_back(i);
			res.push_back(it->second);
			break;
		}else{
			hashMap[nums[i]] = i;
		}
	}
	return res;
}
