#include "header/ValidParentheses.h"

#include <map>
#include <stack>

using std::map;
using std::make_pair;
using std::stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */

 /**
  * 利用辅助栈,判断顺序由紧连的括号至外层嵌套括号
  * time:O(n)
  * space:O(n)
  */
bool ValidParentheses::isValid1(string s) {
	map<char, char> brackets;
	brackets.insert(make_pair('(', ')'));
	brackets.insert(make_pair('[', ']'));
	brackets.insert(make_pair('{', '}'));

	int length = s.size();

	// 奇数
	if (length % 2 != 0) {
		return false;
	}

	stack<char> box;

	for (int i = 0; i < length; i++) {
		char ch = s.at(i);

		if (brackets.find(ch) != brackets.end()) {
			box.push(brackets[ch]);
		} else if (box.empty() || box.top() != ch) {
			return false;
		} else {
			box.pop();
		}
	}

	return box.empty() ? true : false;
}
