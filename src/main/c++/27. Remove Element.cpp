#include "Header.h"

/**
 * https://leetcode.com/problems/remove-element/
 */

 /**
  * 每次遍历，一旦元素相等，便将元素循环前移
  * time:O(n2)
  * space:O(1)
  */
int RemoveElement::removeElement1(vector<int>& nums, int val) {
	int length = nums.size();

	for (int i = 0; i < length; i++) {
		if (nums.at(i) == val) {
			length--;
			for (int j = i; j < length; j++) {
				nums[j] = nums.at(j + 1);
			}
			i--;
		}
	}

	return length;
}

/**
 * 双指针
 * time:O(n)
 * space:O(1)
 */
int RemoveElement::removeElement2(vector<int>& nums, int val) {
	int length = nums.size();
	// 当前存储位置
	int store = 0;

	for (int i = 0; i < length; i++) {
		// 将合法的元素存储，不合法则跳过
		if (nums.at(i) != val) {
			nums[store++] = nums.at(i);
		}

	}

	return store;
}

/**
 * 双指针
 * time:O(n)
 * space:O(1)
 */
int RemoveElement::removeElement3(vector<int>& nums, int val) {
	int length = nums.size();
	int i = 0;

	while (i < length) {
		if (nums.at(i) == val) {
			nums[i] = nums.at(length - 1);
			length--;
		} else {
			i++;
		}
	}

	return length;
}