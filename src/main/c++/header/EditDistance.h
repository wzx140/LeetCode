#pragma once
#include <string>
#include <vector>

using std::vector;
using std::string;

class EditDistance {
public:
	int minDistance1(string word1, string word2);
	int recursive(string& word1, string& word2, int i, int j, vector<vector<int>>& memo);
	int minDistance2(string word1, string word2);
};