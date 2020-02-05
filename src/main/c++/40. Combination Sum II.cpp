#include "Header.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::sort;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */

 /**
  * dfs+回溯
  * @param candidates	候选数组
  * @param target	目标数
  * @param start	候选数组的起始索引
  * @param solution	当前解法
  * @param res	所有解法的集合
  */
void CombinationSum2::dfs(const vector<int>& candidates, int target, int start, vector<int>& solution, vector<vector<int>>& res) {
	if (target == 0) {
		res.push_back(solution);
		return;
	}
	if (start >= candidates.size() || target < candidates[start]) {
		return;
	}

	for (int i = start; i < candidates.size(); i++) {
		// 防止重复
		if (i != start && candidates[i] == candidates[i - 1]) {
			continue;
		}

		solution.push_back(candidates[i]);
		dfs(candidates, target - candidates[i], i + 1, solution, res);
		solution.pop_back();

	}
}

/**
 * 与第39题类似
 */
vector<vector<int>> CombinationSum2::combinationSum1(vector<int>& candidates, int target) {
	vector<vector<int>> res;
	vector<int> solution;
	sort(candidates.begin(), candidates.end());
	dfs(candidates, target, 0, solution, res);

	return res;
}
