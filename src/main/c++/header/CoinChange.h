#pragma once
#include <vector>
#include <map>

using std::map;
using std::vector;

class CoinChange {
public:
	int coinChange1(vector<int>& coins, int amount);
	void backtrack(vector<int>& coins, int amount, int num);
	int coinChange2(vector<int>& coins, int amount);
	int recursive(vector<int>& coins, int amount, map<int, int>& cache);
	int coinChange3(vector<int>& coins, int amount);
};