#pragma once
#include <unordered_map>

using std::unordered_map;

struct Node {
	Node() {
		key = -1;
		val = -1;
		prev = NULL;
		next = NULL;
	}
	int key;
	int val;
	Node* prev;
	Node* next;
};

class LRUCache {
private:
	Node* head;
	Node* tail;
	int capacity;
	unordered_map<int, Node*> hashMap;

	void deleteNode(Node* node);
public:
	LRUCache(int capacity);
	~LRUCache();
	int get(int key);
	void put(int key, int value);
};