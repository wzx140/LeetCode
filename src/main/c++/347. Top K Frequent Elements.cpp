#include "header/TKFE.h"

#include <unordered_map>

using std::unordered_map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

 /**
  * 优先队列
  * https://masterwangzx.com/2019/10/25/min-heap
  * time:O(n+nlogk)
  * space:O(n)
  */
vector<int> TKFE::topKFrequent1(vector<int>& nums, int k) {
	// 统计个数
	unordered_map<int, int> cnt;
	for (int num : nums) {
		cnt[num]++;
	}

	vector<int> heap;
	heap.reserve(cnt.size());
	for (const auto& kv : cnt) {
		heap.push_back(kv.first);
	}

	// 总共有 n/2 个分支结点
	int len = heap.size();
	for (int i = len / 2 - 1; i >= 0; i--) {
		siftDown(heap, len, cnt, i);
	}

	vector<int> res;
	res.reserve(k);
	for (int i = 0; i < k; i++) {
		res.push_back(heap[0]);
		heap[0] = heap[--len];
		siftDown(heap, len, cnt, 0);
	}
	return res;
}

void TKFE::siftDown(vector<int>& heap, int len, unordered_map<int, int>& cnt, int k) {
	int parent = k;
	// 左子结点
	int child = 2 * k + 1;
	// 暂存
	int tmp = heap[parent];

	while (child < len) {
		// 取左右结点中较大的
		if (child < len - 1 && cnt[heap[child]] < cnt[heap[child + 1]]) {
			child = child + 1;
		}

		if (cnt[tmp] < cnt[heap[child]]) {
			heap[parent] = heap[child];

			parent = child;
			child = 2 * child + 1;
		} else {
			break;
		}
	}

	heap[parent] = tmp;
}
