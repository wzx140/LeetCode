#pragma once
#include <string>
#include <vector>

using std::vector;
using std::string;

class LongestCommonSubsequence {
public:
	int longestCommonSubsequence1(string text1, string text2);
	int recursive(string& text1, string& text2, int i, int j, vector<vector<int>>& memo);
	int longestCommonSubsequence2(string text1, string text2);
};
