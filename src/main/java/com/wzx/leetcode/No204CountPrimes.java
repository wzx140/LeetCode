package com.wzx.leetcode;

import java.util.BitSet;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/count-primes/">https://leetcode.com/problems/count-primes/</a>
 */
public class No204CountPrimes {

  /**
   * 暴力搜索, 超时
   * <p>
   * time: O(n*sqrt(n))
   * space: O(1)
   */
  public int countPrimes1(int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) count++;
    }

    return count;
  }

  private boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * Sieve of Eratosthenes
   * 用位图保存是否素数信息
   * <p>
   * time: O(n*loglogn)
   * space: O(n)
   */
  public int countPrimes2(int n) {
    if (n < 2) return 0;
    BitSet primes = new BitSet(n);
    primes.set(2, n);

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (primes.get(i)) {
        // cur*2, cur*3, ..., cur*n 不是素数
        // 由于是由前向后遍历, cur*2, cur*3, ..., cur*cur 已经被 2,3,...cur标记过了
        for (int j = i * i; j <= n; j += i) {
          primes.set(j, false);
        }
      }
    }

    return primes.cardinality();
  }
}
