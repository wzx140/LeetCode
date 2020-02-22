#pragma once
#include <vector>
#include <string>

using std::vector;
using std::string;

class GroupAnagrams {
public:
	vector<vector<string>> groupAnagrams1(vector<string>& strs);
	vector<vector<string>> groupAnagrams2(vector<string>& strs);
	unsigned int hash(string s);
};
