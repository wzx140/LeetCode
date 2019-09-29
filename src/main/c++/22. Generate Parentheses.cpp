#include "Header.h"

#include <map>
#include <stack>

using std::map;
using std::make_pair;
using std::stack;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */

bool isValid(string s) {
	int balance = 0;
	for (char ch : s) {
		if (ch == '(') {
			balance++;
		} else {
			balance--;
		}
		if (balance < 0) {
			return false;
		}
	}

	return balance == 0;
}

void recursive(vector<string>& res, char* s, int length, int pos) {
	if (pos == length) {
		if (isValid(string(s, s + length))) {
			res.emplace_back(string(s, s + length));
		}
	} else {
		s[pos] = '(';
		recursive(res, s, length, pos + 1);

		s[pos] = ')';
		recursive(res, s, length, pos + 1);
	}
}

/**
 * 遍历所有结果，并判断，竟然没有超出时间限制
 * time:O(2^(2n)n)
 * space:O(2^(2n)n)
 */
vector<string> GenerateParenthesis::generateParenthesis1(int n) {
	vector<string> res;

	if (n == 0) {
		return res;
	}

	recursive(res, new char[n * 2], n * 2, 0);

	return res;
}

void backtrack(vector<string>& res, char* s, int length, int pos, int balance) {
	if (pos == length) {
		res.emplace_back(string(s, s + length));
		return;
	}

	if (balance >= 0 && length - pos > balance) {
		s[pos] = '(';
		backtrack(res, s, length, pos + 1, balance + 1);
	}

	if (balance >= 0) {
		s[pos] = ')';
		backtrack(res, s, length, pos + 1, balance - 1);
	}
}

/**
 * 回溯，每次判断是否valid，减少了循环的次数
 * time:O(4^n/sqrt(n))
 * space:O(4^n/sqrt(n))
 */
vector<string> GenerateParenthesis::generateParenthesis2(int n) {
	vector<string> res;

	if (n == 0) {
		return res;
	}

	backtrack(res, new char[n * 2], n * 2, 0, 0);

	return res;
}

/**
 * 闭合数，不容易理解
 * 这里给出了详细的解释 http://www.ishenping.com/ArtInfo/1219710.html
 * time:O(4^n/sqrt(n))
 * space:O(4^n/sqrt(n))
 */
vector<string> GenerateParenthesis::generateParenthesis3(int n) {
	vector<string> res;

	if (n == 0) {
		res.emplace_back("");
		return res;
	}

	for (int i = 0; i < n; i++) {
		for (const string& left : generateParenthesis3(i)) {
			for (const string& right : generateParenthesis3(n - 1 - i)) {
				res.emplace_back('(' + left + ')' + right);
			}
		}
	}

	return res;
}