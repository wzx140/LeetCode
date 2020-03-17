#pragma once
#include <vector>

using std::vector;

class NonOverlappingIntervals{
public:
	int eraseOverlapIntervals1(vector<vector<int>>& intervals);
	bool static compare(const vector<int> &v1, const vector<int> &v2);
};