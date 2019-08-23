#include "Header.h"

/**
 * https://leetcode.com/problems/reverse-integer/solution/
 */

 /**
  * time:O(log(x)) x大约有log(x)个数字
  * space:O(1)
  */
int ReverseInteger::reverse1(int x) {
	int rev = 0;
	while (x != 0) {
		int pop = x % 10;
		x /= 10;

		// 2^31-1=2147483647 -2^31=-2147483648
		if (rev > std::numeric_limits<int>::max() / 10 || (rev == std::numeric_limits<int>::max() / 10 && pop > 7)) {
			return 0;
		} else if (rev < std::numeric_limits<int>::min() / 10 || (rev == std::numeric_limits<int>::min() / 10 && pop < -8)) {
			return 0;
		}

		rev *= 10;
		rev += pop;
	}
	return rev;
}

/**
 * 判断溢出，leetcode会抛运行时异常，但msvc不会
 * time:O(log(x)) x大约有log(x)个数字
 * space:O(1)
 */
int ReverseInteger::reverse2(int x) {
	int rev = 0;
	while (x != 0) {
		int pop = x % 10;
		x /= 10;

		// 不能还原说明溢出
		if((rev*10+pop)%10!=pop){
			return 0;
		}

		rev *= 10;
		rev += pop;
	}
	return rev;
}