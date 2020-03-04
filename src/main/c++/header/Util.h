#pragma once
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using std::cout;
using std::endl;
using std::vector;
using std::abs;

/**
 * 打印矩阵和向量
 */
namespace demonstrate {
	inline void printMatrix(vector<vector<int>> &matrix) {
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix[i].size(); j++) {
				cout << matrix[i][j] << ' ';
			}
			cout << endl;
		}
		cout << endl;
	}
	inline void printVector(vector<int> &nums) {
		for (int i = 0; i < nums.size(); i++) {
			cout << nums[i] << ' ';
		}
		cout << endl;
	}
}

/**
 * 链表结构
 */
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

inline ListNode* buildNodeList(vector<int>& source) {
	ListNode* pre = new ListNode(0);
	ListNode* last = pre;
	for (int i = 0; i < source.size(); i++) {
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

/**
 * 树结构
 */
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

inline TreeNode* buildTree(vector<float>& source) {
	TreeNode* root = NULL;
	if (source.empty()) {
		return root;
	}

	root = new TreeNode(source[0]);
	vector<TreeNode*> nodes;
	nodes.push_back(root);
	int base = 1;
	TreeNode * node = NULL;
	TreeNode* child = NULL;
	while (!nodes.empty()) {
		vector<TreeNode*> layer;

		int layerBase = 0;
		for (TreeNode* node : nodes) {
			int left = base + layerBase;
			int right = left + 1;

			if (left < source.size() && abs(source[left] - (int)source[left]) < 0.1) {
				child = new TreeNode(source[left]);
				node->left = child;
				layer.push_back(child);
			}
			if (right < source.size() && abs(source[right] - (int)source[right]) < 0.1) {
				child = new TreeNode(source[right]);
				node->right = child;
				layer.push_back(child);
			}
			layerBase += 2;
		}

		nodes.clear();
		nodes = layer;
		base += layerBase;
	}

	return root;
}