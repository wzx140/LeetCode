#pragma once
#include <string>
#include "Utills.h"
using namespace data;
using std::string;

class AddTwoNumbers {
public:
	ListNode* addTwoNumbers1(ListNode* l1, ListNode* l2);
};

class LongestSubstringWithoutRepeatingCharacters {
public:
	int lengthOfLongestSubstring1(string s);
	int lengthOfLongestSubstring2(string s);
	int lengthOfLongestSubstring3(string s);
};

class MedianOfTwoSortedArrays {
public:
	double findMedianSortedArrays1(vector<int>& nums1, vector<int>& nums2);
	double findMedianSortedArrays2(vector<int>& nums1, vector<int>& nums2) ;
};
