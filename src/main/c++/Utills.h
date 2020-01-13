#pragma once
#include <vector>
#include <iostream>

using std::cout;
using std::endl;
using std::vector;

/**
 * 打印矩阵和向量
 */
namespace demonstrate{
	inline void printMatrix(vector<vector<int>> &matrix){
		for(int i=0; i<matrix.size(); i++){
			for(int j = 0; j < matrix[i].size(); j++) {
				cout << matrix[i][j] << ' ';
			}
			cout<<endl;
		}
		cout << endl;
	}
	inline void printVector(vector<int> &nums){
		for(int i=0; i<nums.size(); i++){
			cout << nums[i] << ' ';
		}
		cout << endl;
	}
}

/**
 * 链表结构
 */
namespace data{
	struct ListNode {
		int val;
		ListNode *next;
		ListNode(int x) : val(x), next(NULL) {}
	};
	inline ListNode* buildNodeList(vector<int>& source) {
		ListNode* pre = new ListNode(0);
		ListNode* last = pre;
		for (int i = 0; i < source.size() ; i++){
			ListNode* temp = new ListNode(source[i]);
			last->next = temp;
			last = last->next;
		}
		return pre->next;
	}
	inline vector<int> decompositeNodeList(ListNode* source) {
		vector<int> res;
		while (source != NULL) {
			res.push_back(source->val);
			source = source->next;
		}
		return res;
	}
}