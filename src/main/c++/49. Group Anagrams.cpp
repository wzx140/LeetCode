#include "Header.h"

#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using std::vector;
using std::string;
using std::unordered_map;
using std::sort;

/**
 * https://leetcode.com/problems/group-anagrams/
 */

 /**
  * 如果两个字符串是anagrams，那么排序后两者相同
  * time:O(nklogk)
  * space:O(nk)
  */
vector<vector<string>> GroupAnagrams::groupAnagrams1(vector<string>& strs) {
	unordered_map<string, vector<string>> dict;
	for (const string& str : strs) {
		string ca = str;
		sort(ca.begin(), ca.end());
		dict[ca].push_back(str);
	}
	vector<vector<string>> res;
	for (const auto& str : dict) {
		res.push_back(vector<string>(str.second.begin(), str.second.end()));
	}
	return res;
}

/**
 * 如果两个字符串是anagrams，那么两者的字符构成相同。由于题目规定只可能是26个字母,所以由string得到字母表count，进行比较
 * time:O(nk)
 * space:O(nk)
 */
vector<vector<string>> GroupAnagrams::groupAnagrams2(vector<string>& strs) {
	unordered_map<unsigned int, vector<string>> dict;
	for (const string& str : strs) {
		dict[hash(str)].push_back(str);
	}
	vector<vector<string>> res;
	for (const auto& str : dict) {
		res.push_back(vector<string>(str.second.begin(), str.second.end()));
	}
	return res;
}

/**
 * 对每个string进行哈希运算
 */
unsigned int GroupAnagrams::hash(string s) {
	unsigned int ans = 0;
	int has[26] = { 0 };
	for (auto ch : s) {
		has[ch - 'a'] ++;
	}
	for (int i = 0; i < 26; i++)
		ans = ans * 26 + has[i];
	return ans;
}