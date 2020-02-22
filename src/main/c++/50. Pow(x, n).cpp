#include "header/MyPow.h"

/**
 * https://leetcode.com/problems/powx-n/
 */

 /**
  * 按部就班，暴力解法，TLE
  * time:O(n)
  * space:O(1)
  */
double MyPow::myPow1(double x, int n) {
	long N = n;
	if (N < 0) {
		x = 1 / x;
		N = -N;
	}
	double ans = 1;
	for (int i = 0; i < N; i++) {
		ans *= x;
	}
	return ans;
}

/**
 * 二分递归
 * time:O(logn)
 * space:O(logn)
 */
double MyPow::myPow2(double x, int n) {
	long N = n;
	if (N < 0) {
		x = 1 / x;
		N = -N;
	}

	return fastPow(x, N);
}

double MyPow::fastPow(double x, long n) {
	if (n == 0) {
		return 1.0;
	}
	double half = fastPow(x, n / 2);
	if (n % 2 == 0) {
		return half * half;
	} else {
		return half * half * x;
	}
}


/**
 * 二分循环形式，把n看成二进制数，类似29题用位运算的方法
 * time:O(logn)
 * space:O(1)
 */
double MyPow::myPow3(double x, int n) {
	long N = n;
	if (N < 0) {
		x = 1 / x;
		N = -N;
	}
	double ans = 1;
	double base = x;
	// 按位计算
	for (long bit = 1; bit <= N; bit <<= 1) {
		if ((N & bit) != 0) {
			ans *= base;
		}
		base *= base;
	}
	return ans;
}
