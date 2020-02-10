#pragma once
#include <string>
#include "Utills.h"
using namespace data;
using std::string;

/**
 * 为了方便，所以把所有题的头文件都放到一起
 */

class Sum2 {
public:
	vector<int> twoSum1(vector<int>& nums, int target);
	vector<int> twoSum2(vector<int>& nums, int target);
	vector<int> twoSum3(vector<int>& nums, int target);
};

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

class PalindromeNumber {
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
};

class Sum3Closest {
public:
	int threeSumClosest1(vector<int>& nums, int target);
};

class Atoi {
public:
	int myAtoi1(string str);
};

class LCPN {
public:
	vector<string> letterCombinations1(string digits);
	vector<string> letterCombinations2(string digits);
};

class Sum4 {
public:
	vector<vector<int>> fourSum1(vector<int>& nums, int target);
};

class RNEL {
public:
	ListNode* removeNthFromEnd1(ListNode* head, int n);
};

class ValidParentheses {
public:
	bool isValid1(string s);
};

class MTSL {
public:
	ListNode* mergeTwoLists1(ListNode* l1, ListNode* l2);
	ListNode* mergeTwoLists2(ListNode* l1, ListNode* l2);
};

class GenerateParenthesis {
public:
	vector<string> generateParenthesis1(int n);
	vector<string> generateParenthesis2(int n);
	vector<string> generateParenthesis3(int n);
};

class SNP {
public:
	ListNode* swapPairs1(ListNode* head);
	ListNode* swapPairs2(ListNode* head);
};

class RDSA {
public:
	int removeDuplicates1(vector<int>& nums);
	int removeDuplicates2(vector<int>& nums);
};

class RemoveElement {
public:
	int removeElement1(vector<int>& nums, int val);
	int removeElement2(vector<int>& nums, int val);
	int removeElement3(vector<int>& nums, int val);
};

class ImplementStrStr {
public:
	int strStr1(string haystack, string needle);
	int strStr2(string haystack, string needle);
};

class DivideTwoIntegers {
public:
	int divide1(int dividend, int divisor);
	int divide2(int dividend, int divisor);
	int divide3(int dividend, int divisor);
};

class NextPermutation {
public:
	void nextPermutation1(vector<int>& nums);
	void nextPermutation2(vector<int>& nums);
};

class SRSA {
public:
	int search1(vector<int>& nums, int target);
	int search2(vector<int>& nums, int target);
};

class SortArray {
public:
	vector<int> sortArray1(vector<int>& nums);
	vector<int> sortArray2(vector<int>& nums);
	vector<int> sortArray3(vector<int>& nums);
	vector<int> sortArray4(vector<int>& nums);
	vector<int> sortArray5(vector<int>& nums);
	vector<int> sortArray6(vector<int>& nums);
	vector<int> sortArray7(vector<int>& nums);
	vector<int> sortArray8(vector<int>& nums);
	vector<int> sortArray9(vector<int>& nums);
};

class MergeKSortedLists {
public:
	ListNode* mergeKLists1(vector<ListNode*>& lists);
};

class FFLP {
public:
	vector<int> searchRange1(vector<int>& nums, int target);
};

class SearchInsertPosition {
public:
	int searchInsert1(vector<int>& nums, int target);
};

class ValidSudoku {
public:
	bool isValidSudoku1(vector<vector<char>>& board);
	bool isValidSudoku2(vector<vector<char>>& board);
};

class SudokuSolver {
public:
	void solveSudoku1(vector<vector<char>>& board);
};

class CountSay {
public:
	string countAndSay1(int n);
};

class CombinationSum {
public:
	vector<vector<int>> combinationSum1(vector<int>& candidates, int target);
	void dfs(const vector<int>& candidates, int target, int start, vector<int>& solution, vector<vector<int>>& res);
};

class CombinationSum2 {
public:
	vector<vector<int>> combinationSum1(vector<int>& candidates, int target);
	void dfs(const vector<int>& candidates, int target, int start, vector<int>& solution, vector<vector<int>>& res);
};

class FirstMissingPositive {
public:
	int firstMissingPositive1(vector<int>& nums);
	int firstMissingPositive2(vector<int>& nums);
};

class TrappingRainWater {
public:
	int trap1(vector<int>& height);
	int trap2(vector<int>& height);
	int trap3(vector<int>& height);
};

class MultiplyStrings {
public:
	string multiply1(string num1, string num2);
};

class JumpGame2 {
public:
	int jump1(vector<int>& nums);
	int jump2(vector<int>& nums);
};