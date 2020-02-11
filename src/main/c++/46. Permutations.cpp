#include "Header.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::swap;

/**
 * https://leetcode.com/problems/permutations/
 */

 /**
  * 深搜+回溯
  * time:O(\sum_1^N(P(N,k)))
  * space:O(\sum_1^N(P(N,k)))
  */
vector<vector<int>> Permutations::permute1(vector<int>& nums) {
	vector<vector<int>> perms;
	vector<int> perm;
	vector<int> indexes;
	for (int i = 0; i < nums.size(); i++) {
		indexes.push_back(i);
	}
	dfs1(nums, indexes, perms, perm);
	return perms;
}

/**
 * indexes维护了当前可以添加的元素索引，每添加一个元素，就从中删去对应的索引
 */
void Permutations::dfs1(vector<int>& nums, vector<int>& indexes, vector<vector<int>>& perms, vector<int>& perm) {
	if (perm.size() == nums.size()) {
		perms.push_back(perm);
		return;
	}

	for (int i = 0; i < indexes.size(); i++) {
		perm.push_back(nums[indexes[i]]);
		vector<int> temp = indexes;
		temp.erase(temp.begin() + i);
		dfs1(nums, temp, perms, perm);
		perm.pop_back();
	}
}

/**
 * 深搜+回溯
 * time:O(\sum_1^N(P(N,k)))
 * space:O(n)
 */
vector<vector<int>> Permutations::permute2(vector<int>& nums) {
	vector<vector<int>> perms;
	int length = nums.size();
	dfs2(nums, 0, length, perms);
	return perms;
}

/**
 * 官方解答用了一种巧妙的交换元素的方法，这样就不用维护一个记录未使用元素的列表了
 */
void Permutations::dfs2(vector<int>& nums, int first, int n, vector<vector<int>>& perms) {
	if (first == n) {
		perms.push_back(nums);
		return;
	}

	for (int i = first; i < n; i++) {
		swap(nums[i], nums[first]);
		dfs2(nums, first + 1, n, perms);
		swap(nums[i], nums[first]);
	}
}