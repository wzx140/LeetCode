#include "Header.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::sort;
using std::swap;

/**
 * https://leetcode.com/problems/permutations-ii/
 */


 /**
  * 深搜+回溯
  * time:O(\sum_1^N(P(N,k)))
  * space:O(n)
  */
vector<vector<int>> Permutations2::permuteUnique1(vector<int>& nums) {
	sort(nums.begin(), nums.end());
	vector<vector<int>> perms;
	vector<int> perm;
	vector<bool> used(nums.size(), false);
	dfs1(nums, used, perms, perm);
	return perms;
}

/**
 * 在46题方法一的基础上改进：used数组维护了元素是否在当前组合中被使用
 * 46题方法二不好改进，因为nums数组顺序被打乱，判断重复元素将很困难，增加了时间复杂度
 */
void Permutations2::dfs1(vector<int>& nums, vector<bool>& used, vector<vector<int>>& perms, vector<int>& perm) {
	if (perm.size() == nums.size()) {
		perms.push_back(perm);
		return;
	}

	for (int i = 0; i < nums.size(); i++) {
		if (!used[i]) {
			// 若前一个重复元素已经完成过组合，那么后面重复元素的组合就是多余的
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			perm.push_back(nums[i]);
			used[i] = true;
			dfs1(nums, used, perms, perm);
			perm.pop_back();
			used[i] = false;
		}
	}
}
