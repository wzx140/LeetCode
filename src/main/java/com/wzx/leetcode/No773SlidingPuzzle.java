package com.wzx.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/sliding-puzzle/">https://leetcode.com/problems/sliding-puzzle/</a>
 * @author wzx
 */
public class No773SlidingPuzzle {

  /**
   * 0处于不同位置, 其他可以移动的square
   */
  private final static int[][] move = {
          {1, 3},
          {0, 2, 4},
          {1, 5},
          {0, 4},
          {1, 3, 5},
          {2, 4}
  };

  /**
   * 双向BFS
   *
   * time: O(n)
   * space: O(n)
   */
  public int slidingPuzzle(int[][] board) {
    // 起始位置
    char[] start = new char[6];
    for (int i = 0; i < 3; i++) {
      start[i] = (char) (board[0][i] + '0');
    }
    for (int i = 0; i < 3; i++) {
      start[i + 3] = (char) (board[1][i] + '0');
    }
    String end = "123450";
    Set<String> visit = new HashSet<>();
    // 用set便于找到交集
    Set<String> set1 = new HashSet<>();
    set1.add(String.valueOf(start));
    Set<String> set2 = new HashSet<>();
    set2.add(end);

    int step = 0;
    while (!set1.isEmpty() && !set2.isEmpty()) {
      // 每次优先拓展较小的那一侧
      if (set1.size() > set2.size()) {
        Set<String> tmp = set1;
        set1 = set2;
        set2 = tmp;
      }
      // 向前拓展一层
      Set<String> newSet = new HashSet<>();
      for (String puzzle : set1) {
        // 找到交集
        if (set2.contains(puzzle)) return step;
        // 找到0所在位置
        int zeroPos = 0;
        while (puzzle.charAt(zeroPos) != '0') {
          zeroPos++;
        }
        // 移动
        if (!visit.contains(puzzle)) {
          visit.add(puzzle);
          for (int changePos : move[zeroPos]) {
            newSet.add(swap(puzzle, zeroPos, changePos));
          }
        }
      }
      set1 = newSet;
      step++;
    }

    return -1;
  }

  private String swap(String puzzle, int i, int j) {
    char[] array = puzzle.toCharArray();
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
    return String.valueOf(array);
  }

}
