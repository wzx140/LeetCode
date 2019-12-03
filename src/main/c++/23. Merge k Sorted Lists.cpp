#include "Header.h"

#include <cmath>
#include <limits>

using std::log;
using std::pow;
using std::numeric_limits;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

 /**
  * 败者/胜者树应该是最优解，最小堆虽然复杂度也是nlogk，但是多了一半的比较次数
  * time:O(nlogk)
  * space:O(k+n)
  */
class LoserTree {
private:
	int n;					// 选手个数
	int* ls;				// 分支结点数组(索引)
	vector<ListNode*> b;	// 叶结点数组(外部序列的首个元素)
	int exSize;				// 最底层外部结点个数
	int offset;				// 最底层外部结点之上的结点个数
	void play(int inParent, int exLeft, int exRight);
public:
	// 败者树的分支节点数与叶结点数相等
	LoserTree(int treeSize) { ls = new int[treeSize]; }
	~LoserTree() { delete[]ls; }
	void initialize(vector<ListNode*>& lists, int size);
	void replay(int i);
	int getWinner() { return n ? b[ls[0]]->val : b[0]->val; }
	int getWinnerIndex() { return n ? ls[0] : 0; }
};

// inParent:父结点索引(分支结点) exLeft:左子结点的外部序列索引 exRight：右子结点的外部序列索引
void LoserTree::play(int inParent, int exLeft, int exRight) {
	// 失败者存入父结点
	ls[inParent] = b[exLeft]->val > b[exRight]->val ? exLeft : exRight;
	int exWinner = b[exLeft]->val <= b[exRight]->val ? exLeft : exRight;

	// initialize的顺序是从左至右的外部序列两两比较，没必要对左分支和右分支处理的时候都上升比较
	// 只对右分支上升比较一次
	while (inParent > 1 && inParent % 2 != 0) {
		// 这里的完全二叉树是从b[1]开始的，所以父结点为 p/2
		int temp = b[exWinner]->val <= b[ls[inParent / 2]]->val ? exWinner : ls[inParent / 2];
		// 胜者每次与父结点比较
		ls[inParent / 2] = b[exWinner]->val > b[ls[inParent / 2]]->val ? exWinner : ls[inParent / 2];
		// 胜者向上传递
		exWinner = temp;
		inParent /= 2;
	}
	// 把胜者存到祖父结点，等待下一次右分支的胜者与其比较
	// inParent=1时,ls[0]=winner
	ls[inParent / 2] = exWinner;
}

void LoserTree::initialize(vector<ListNode*>& lists, int size) {
	this->n = size;
	this->b = lists;

	// 计算最底层外部结点个数
	this->exSize = 2 * n - pow(2, int(log(2 * n) / log(2)));

	// 为了便于计算最底层外部结点的父结点索引，所以求offset
	this->offset = pow(2, int(log(2 * n) / log(2)));

	// 最底层和次底层的外部结点需要分开处理，以应对内部节点和外部结点比较的情况
	// 以及确定父结点位置
	for (int i = 1; i < this->exSize; i += 2) {
		play((i + offset) / 2, i - 1, i);
	}
	int start = this->exSize + 1;
	if (n % 2 != 0) {
		play((n - 1) / 2, ls[(n - 1) / 2], this->exSize);
		// 次底层的外部结点有一个与内部结点比较了
		// 所以次底层的结点间比较的起始点+1
		start++;
	}
	for (int i = start; i < n; i += 2) {
		play((i - this->exSize + n - 1) / 2, i - 1, i);
	}

}

// 第i个外部叶结点改变了
void LoserTree::replay(int i) {
	if (b[i]->next != NULL) {
		b[i] = b[i]->next;
	} else {
		b[i] = new ListNode(numeric_limits<int>::max());
	}

	// 父结点位置
	int inParent = 0;
	if (i < this->exSize) {
		inParent = (i + offset) / 2;
	} else {
		inParent = (i - this->exSize + n) / 2;
	}

	int exWinner = b[i]->val <= b[ls[inParent]]->val ? i : ls[inParent];
	ls[inParent] = b[i]->val > b[ls[inParent]]->val ? i : ls[inParent];
	while (inParent / 2 >= 1) {
		int temp = b[exWinner]->val <= b[ls[inParent / 2]]->val ? exWinner : ls[inParent / 2];
		ls[inParent / 2] = b[exWinner]->val > b[ls[inParent / 2]]->val ? exWinner : ls[inParent / 2];
		exWinner = temp;
		inParent /= 2;
	}
	ls[0] = exWinner;
}

ListNode* MergeKSortedLists::mergeKLists1(vector<ListNode*>& lists) {

	// 去除空元素
	auto iter = lists.begin();
	while (iter != lists.end()) {
		if (*iter == NULL) {
			iter = lists.erase(iter);
		} else {
			++iter;
		}
	}

	int n = lists.size();
	if (n == 0) {
		return NULL;
	} else if (n == 1) {
		return lists[0];
	}

	LoserTree loserTree(n);
	loserTree.initialize(lists, n);

	ListNode* pre = new ListNode(0);
	ListNode* last = pre;
	int res = 0;
	while ((res = loserTree.getWinner()) != numeric_limits<int>::max()) {
		loserTree.replay(loserTree.getWinnerIndex());
		ListNode* temp = new ListNode(res);
		last->next = temp;
		last = last->next;
	}

	return pre->next;
}
