#pragma once
#include <vector>
#include <unordered_map>

using std::vector;
using std::unordered_map;

class TKFE {
public:
	vector<int> topKFrequent1(vector<int>& nums, int k);
	void siftDown(vector<int>& heap, int len, unordered_map<int, int>& cnt, int k);
};