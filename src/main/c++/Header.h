﻿#pragma once
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
	double findMedianSortedArrays2(vector<int>& nums1, vector<int>& nums2);
};

class LongestPalindromicSubstring {
public:
	string longestPalindrome1(string s);
	string longestPalindrome2(string s);
	string longestPalindrome3(string s);
	string longestPalindrome4(string s);
};

class ReverseInteger {
public:
	int reverse1(int x);
	int reverse2(int x);
};

class ZigZagConversion {
public:
	string convert1(string s, int numRows);
	string convert2(string s, int numRows);
	string convert3(string s, int numRows);
};

class PalindromeNumber{
public:
	bool isPalindrome1(int x);
	bool isPalindrome2(int x);
	bool isPalindrome3(int x);
};

class ContainerWithMostWater {
public:
	int maxArea1(vector<int>& height);
	int maxArea2(vector<int>& height);
};

class IntegerToRoman {
public:
	string intToRoman1(int num);
	string intToRoman2(int num);
};

class RomanToInteger {
public:
	int romanToInt(string s);
};

class Sum3 {
public:
	vector<vector<int>> threeSum1(vector<int>& nums);
	vector<vector<int>> threeSum2(vector<int>& nums);
};