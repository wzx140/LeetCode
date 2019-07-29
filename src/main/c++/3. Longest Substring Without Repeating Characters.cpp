#include "Header.h"
#include <algorithm>
#include <unordered_map>

using std::unordered_map;
using std::make_pair;

// deleting and add element in vector and search in vector may be a huge overhead
int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring1(string s){	
	int maxLength = 0;
	int length = s.length();
	int i = 0;
	int j = 0;
	// current non-repeating array
	vector<char> currArray;

	while (i < length && j < length){
		auto finder = std::find(currArray.begin(), currArray.end(), s[j]);
		if(finder != currArray.end()){
			int currLength = currArray.size();
			maxLength = std::max(maxLength, currLength);

			// delete elements before current duplicate element
			int temp = std::distance(currArray.begin(), finder);
			for (int k = 0; k <= temp; k++){
				currArray.erase(currArray.begin());
			}
		}

		currArray.push_back(s[j++]);
	}

	int currLength = currArray.size();
	maxLength = std::max(maxLength, currLength);

	return maxLength;
}

// use hash map to reduce search time to O(1)
// replace deleting element in hash map of updating the index
int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring2(string s){	
	int maxLength = 0;
	int length = s.length();
	int i = 0;
	int j = 0;

	unordered_map<char, int> map;

	while (i < length && j < length){
		unordered_map<char, int>::iterator finder = map.find(s[j]);
		if(finder != map.end()){
			i = std::max(i, finder->second + 1);
			finder->second = j;
		}else{
			map.insert(make_pair((char)s[j], j));
		}
		maxLength = std::max(maxLength, j - i + 1);
		j++;
	}

	return maxLength;
}

// use int array
int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring3(string s){	
	int maxLength = 0;
	int length = s.length();
	int i = 0;
	int j = 0;

	int * index = new int[128];

	while (i < length && j < length){
		i = std::max(i, index[s[j]] + 1);
		maxLength = std::max(maxLength, j - i + 1);
		index[s[j]] = j;
		j++;
	}

	return maxLength;
}