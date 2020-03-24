#include "header/LRUCache.h"

/**
 * https://leetcode.com/problems/lru-cache/
 */

 /**
  * 在哈希map<int,node>基础之上，增加node(key,value)的双向链表
  */

LRUCache::LRUCache(int capacity) :hashMap(capacity) {
	head = NULL;
	tail = NULL;
	this->capacity = capacity;
}

LRUCache::~LRUCache() {
	Node* node = head;
	while (node != NULL) {
		Node* next = node->next;
		delete node;
		node = next;
	}
}

int LRUCache::get(int key) {
	if (hashMap.find(key) == hashMap.end()) {
		return -1;
	} else {
		put(key, hashMap[key]->val);
		return hashMap[key]->val;
	}
}

void LRUCache::put(int key, int value) {
	Node* node = NULL;
	if (hashMap.find(key) != hashMap.end()) {
		// 更新原来的node
		node = hashMap[key];
		node->val = value;

	} else {
		// 删除旧结点
		if (hashMap.size() == capacity) {
			hashMap.erase(hashMap.find(tail->key));
			Node* dNode = tail;
			deleteNode(dNode);
			delete dNode;
		}
		// 新结点
		node = new Node;
		node->key = key;
		node->val = value;
		hashMap[key] = node;
	}

	deleteNode(node);
	// 将节点放在头部
	if (NULL == head) {
		head = node;
		tail = node;
	} else if (node != head) {
		node->next = head;
		node->prev = NULL;
		head->prev = node;
		head = node;
	}
}

/**
 * 删除结点在双向链表中的关系
 */
void LRUCache::deleteNode(Node* node) {
	if (node == tail) {
		tail = node->prev;
	}
	if (NULL != node->prev || node == tail) {
		node->prev->next = node->next;
	}

	if (node == head) {
		head = node->next;
	}
	if (NULL != node->next || node == head) {
		node->next->prev = node->prev;
	}

	node->next = NULL;
	node->prev = NULL;
}
