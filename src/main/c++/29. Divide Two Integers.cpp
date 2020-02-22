#include "header/DivideTwoIntegers.h"

#include <limits>

using std::numeric_limits;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */

 /**
  * 循环做差，超出时间限制
  * time:O(n)
  * space:O(1)
  */
int DivideTwoIntegers::divide1(int dividend, int divisor) {

	// 确定商的符号
	bool sign = (dividend < 0) ^ (divisor < 0);

	// 除数和被除数都转化为负数，防止溢出
	if (dividend > 0) {
		dividend = -dividend;
	}
	if (divisor > 0) {
		divisor = -divisor;
	}

	int quotient = 0;
	while (dividend <= divisor) {
		// 判断商是否溢出
		if (!sign && quotient == -numeric_limits<int>::max()) {
			return numeric_limits<int>::max();
		} else if (sign && quotient == numeric_limits<int>::min()) {
			return numeric_limits<int>::min();
		}

		// 商也用负数表示，防止溢出
		quotient--;
		dividend -= divisor;
	}

	return sign ? quotient : -quotient;
}

/**
 * 上一个例子每次做差的数都很小。应该先将除数倍增构成等比数列，再依次做差
 * time:O(logn)
 * space:O(logn)
 */
int DivideTwoIntegers::divide2(int dividend, int divisor) {

	// 确定商的符号
	bool sign = (dividend < 0) ^ (divisor < 0);

	// 除数和被除数都转化为负数，防止溢出
	if (dividend > 0) {
		dividend = -dividend;
	}
	if (divisor > 0) {
		divisor = -divisor;
	}

	// 构造除数的倍增数列和对应商增加量数列
	int dvs[32];
	int dv = divisor;
	int i = -1;			// 数列最后一位
	int dQuotients[32];	// 数列元素对应商的增加量
	int dQuotient = -1;	// 商的增量也用负数，防止溢出
	while (dv >= dividend) {
		i++;
		dvs[i] = dv;
		dQuotients[i] = dQuotient;


		if (dv >= numeric_limits<int>::min() - dv) {
			dv += dv;
			dQuotient += dQuotient;
		} else {
			break;
		}
	}

	// 将数列里的数依次作为除数，执行类似方法一的循环做差
	int quotient = 0;
	for (; i >= 0; i--) {
		int dv = dvs[i];
		int dQuotient = dQuotients[i];

		while (dv >= dividend) {

			dividend -= dv;
			quotient += dQuotient;

			// 判断商是否溢出
			if (!sign && quotient <= numeric_limits<int>::min() + 1) {
				return numeric_limits<int>::max();
			} else if (sign && quotient == numeric_limits<int>::min()) {
				return numeric_limits<int>::min();
			}
		}

	}

	return sign ? quotient : -quotient;
}

/**
 * 利用位运算让除数变化，这里没有预先存储这些位运算后的数列
 * time:O(lognlogn)
 * space:O(1)
 */
int DivideTwoIntegers::divide3(int dividend, int divisor) {
	// 确定商的符号
	bool sign = (dividend < 0) ^ (divisor < 0);

	// 转化为long，防止溢出
	//这里如果转化为负数的话，后面的位操作不好判断溢出
	long uDividend = abs((long)dividend);
	long uDivisor = abs((long)divisor);

	long quotient = 0;
	while (uDivisor <= uDividend) {
		long dv = uDivisor;
		long dQuotient = 1;

		// 循环左移一位，直到除数刚好小于被除数
		while (uDividend >= (dv << 1)) {
			dv <<= 1;
			dQuotient <<= 1;
		}
		uDividend -= dv;
		quotient += dQuotient;

		// 判断商是否溢出
		if (!sign && quotient >= numeric_limits<int>::max()) {
			return numeric_limits<int>::max();
		} else if (sign && quotient <= numeric_limits<int>::min()) {
			return numeric_limits<int>::min();
		}
	}

	return sign ? -quotient : quotient;
}
