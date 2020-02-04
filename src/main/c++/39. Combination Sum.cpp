#include "Header.h"

#include <algorithm>

using std::vector;
using std::sort;

/**
 * https://leetcode.com/problems/combination-sum/
 */

 /**
  * dfs+回溯
  * @param candidates	候选数组
  * @param target	目标数
  * @param start	候选数组的起始索引
  * @param solution	当前解法
  * @param res	所有解法的集合
  */
void dfs(const vector<int>& candidates, int target, int start, vector<int>& solution, vector<vector<int>>& res) {
	if (target == 0) {
		res.push_back(solution);
		return;
	}
	if (target < candidates[start]) {
		return;
	}

	for (int i = start; i < candidates.size(); i++) {
		solution.push_back(candidates[i]);
		dfs(candidates, target - candidates[i], i, solution, res);
		solution.pop_back();
	}
}

/**
 * 深搜
 */
vector<vector<int>> CombinationSum::combinationSum1(vector<int>& candidates, int target) {
	vector<vector<int>> res;
	vector<int> solution;
	sort(candidates.begin(), candidates.end());
	dfs(candidates, target, 0, solution, res);

	return res;
}
