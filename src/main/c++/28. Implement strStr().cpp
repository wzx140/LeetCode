#include "header/ImplementStrStr.h"

/**
 * https://leetcode.com/problems/implement-strstr/
 */

 /**
  * 暴力破解
  * time:O(n)
  * space:O(n)
  */
int ImplementStrStr::strStr1(string haystack, string needle) {
	int hayLength = haystack.size();
	int needleLength = needle.size();

	if (needleLength == 0) {
		return 0;
	}

	for (int i = 0; i < hayLength; i++) {

		if (hayLength - i >= needleLength) {
			bool flag = true;
			for (int j = 0; j < needleLength; j++) {
				if (haystack.at(i + j) != needle.at(j)) {
					flag = false;
				}
			}
			if (flag) {
				return i;
			}
		}

	}

	return -1;
}

//todo: 留个坑，kmp
int ImplementStrStr::strStr2(string haystack, string needle) {
	return 0;
}
