package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 *
 * @author wzx
 */
public class No60NumberOfNDice {

  /**
   * 递归暴力解法
   * <p>
   * time: O(6^n)
   * space: O(1)
   */
  public double[] twoSum1(int n) {
    // 所有可能出现的点数和
    int min = n, max = 6 * n;
    double[] res = new double[max - min + 1];

    // 计算总次数
    for (int i = min; i <= max; i++) {
      res[i - min] = recursion(n, i);
    }

    // 计算概率
    int sum = (int) Math.pow(6, n);
    for (int i = 0; i < res.length; i++) {
      res[i] /= sum;
    }

    return res;
  }

  /**
   * 递归计算点数出现次数
   *
   * @param n 骰子个数
   * @param k 要出现的点数
   * @return 出现次数
   */
  private int recursion(int n, int k) {
    // 只有一个骰子时，每个点数只能出现一次
    if (n == 1) return 1;

    // 其中一个骰子的点数分别为1~6,其他骰子点数和对应为min(k-1, 6(n-1)) ~ max(k-6,1)
    int sum = 0;
    for (int i = Math.min(k - 1, 6 * (n - 1)); i >= Math.max(k - 6, 1); i--) {
      sum += recursion(n - 1, i);
    }

    return sum;
  }

  /**
   * 自顶向下，递归加备忘录
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public double[] twoSum2(int n) {
    // 所有可能出现的点数和
    int min = n, max = 6 * n;
    // 备忘录
    int[][] memo = new int[n][6 * n];
    for (int i = 0; i < 6; i++) {
      memo[0][i] = 1;
    }

    // 计算总次数
    double[] res = new double[max - min + 1];
    for (int i = min; i <= max; i++) {
      res[i - min] = recursion(n, i, memo);
    }

    // 计算概率
    int sum = (int) Math.pow(6, n);
    for (int i = 0; i < res.length; i++) {
      res[i] /= sum;
    }

    return res;
  }

  /**
   * 用备忘录防止重复计算
   */
  private int recursion(int n, int k, int[][] memo) {
    if (memo[n - 1][k - 1] != 0) return memo[n - 1][k - 1];

    int sum = 0;
    for (int i = Math.min(k - 1, 6 * (n - 1)); i >= Math.max(k - 6, 1); i--) {
      sum += recursion(n - 1, i, memo);
    }
    memo[n - 1][k - 1] = sum;

    return sum;
  }

  /**
   * 自底向上，动态规划
   * dp[i][j]: 掷i个骰子,点数j出现的次数
   * 递推: dp[n][k] = sum_{i-1}^6{dp[n-1][k-1]}
   * dp[i][j] ->(优化) dp[j]
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public double[] twoSum3(int n) {
    // 边界
    int[] dp = new int[6 * n + 1];
    for (int i = 1; i <= 6; i++) {
      dp[i] = 1;
    }

    // i 骰子个数
    for (int i = 2; i <= n; i++) {
      // i-1个骰子所能出现的最大和最小点数
      int minPoint = i - 1, maxPoint = 6 * (i - 1);
      // j i个骰子可能出现的点数和
      for (int j = 6 * i; j >= i; j--) {
        // 此处的值在上一个循环中已经使用过，赋值为0防止干扰本次循环求值
        dp[j] = 0;
        // k 第i个骰子的点数
        // 满足约束 k>=j-maxPoint k<=j-minPoint
        for (int k = Math.max(j - maxPoint, 1); k <= Math.min(j - minPoint, 6); k++) {
          dp[j] += dp[j - k];
        }
      }
    }

    // 计算概率
    int min = n, max = 6 * n;
    double[] res = new double[max - min + 1];
    double sum = Math.pow(6, n);
    for (int i = min; i <= max; i++) {
      res[i - min] = dp[i] / sum;
    }

    return res;
  }
}
