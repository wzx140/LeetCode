#include "header/LongestSubstringWithoutRepeatingCharacters.h"

#include <algorithm>
#include <unordered_map>
#include <vector>

using std::unordered_map;
using std::make_pair;
using std::vector;
using std::find;
using std::distance;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

/**
 * 虫取法，使用vector
 * time:O(n2)
 * space:O(n)
 */
int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring1(string s) {
	int maxLength = 0;
	int length = s.length();
	int i = 0;	// 末尾索引

	vector<char> currArray;

	while (i < length) {
		// vector的查找时间复杂度为O(n)
		auto finder = std::find(currArray.begin(), currArray.end(), s[i]);
		if (finder != currArray.end()) {
			int currLength = currArray.size();
			maxLength = std::max(maxLength, currLength);

			// 删除重复元素及之前的所有元素
			int temp = std::distance(currArray.begin(), finder);
			for (int k = 0; k <= temp; k++) {
				currArray.erase(currArray.begin());
			}
		}

		// 每次末尾添加元素
		currArray.push_back(s[i++]);
	}

	int currLength = currArray.size();
	maxLength = std::max(maxLength, currLength);

	return maxLength;
}

/**
 * 用哈希表代替vector
 * time:O(n)
 * space:O(n)
 */
int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring2(string s) {
	int maxLength = 0;
	int length = s.length();
	int i = 0;
	int j = 0;

	unordered_map<char, int> map;

	while (i < length && j < length){
		unordered_map<char, int>::iterator finder = map.find(s[j]);
		if(finder != map.end()){
			i = std::max(i, finder->second + 1);	// 无重复的左端索引
			finder->second = j;		// 更新键值，相当于 map.insert(make_pair((char)s[j], j));
		}else{
			map.insert(make_pair((char)s[j], j));
		}
		maxLength = std::max(maxLength, j - i + 1);
		j++;
	}

	return maxLength;
}

/**
 * 用int数组代替哈希表
 * time:O(n)
 * space:O(m) 取决于字符集大小
 */
int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring3(string s) {
	int maxLength = 0;
	int length = s.length();
	int i = 0;
	int j = 0;

	int * index = new int[128];

	while (i < length && j < length) {
		i = std::max(i, index[s[j]] + 1);
		maxLength = std::max(maxLength, j - i + 1);
		index[s[j]] = j;
		j++;
	}

	return maxLength;
}
