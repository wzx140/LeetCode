#pragma once
#include <vector>

using std::vector;

class MNABB {
public:
	int findMinArrowShots1(vector<vector<int>>& points);
	bool static compare(const vector<int> &v1, const vector<int> &v2);
};