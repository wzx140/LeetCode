package com.wzx.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/open-the-lock/">https://leetcode.com/problems/open-the-lock/</a>
 * @author wzx
 */
public class No752OpenTheLock {

  /**
   * 单向广搜
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int openLock1(String[] deadends, String target) {
    Deque<String> queue = new LinkedList<>();
    // 起点
    queue.addLast("0000");
    Set<String> visit = new HashSet<>(Arrays.asList(deadends));
    int step = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String wheels = queue.pollFirst();
        // 找到目标
        if (target.equals(wheels)) {
          return step;
        }
        if (!visit.contains(wheels)) {
          visit.add(wheels);
          for (int j = 0; j < 4; j++) {
            queue.addLast(rollUp(wheels, j));
            queue.addLast(rollDown(wheels, j));
          }
        }
      }
      step++;
    }

    return -1;
  }

  private String rollUp(String wheels, int index) {
    char[] chars = wheels.toCharArray();
    if (chars[index] == '9') {
      chars[index] = '0';
    } else {
      chars[index]++;
    }
    return new String(chars);
  }

  private String rollDown(String wheels, int index) {
    char[] chars = wheels.toCharArray();
    if (chars[index] == '0') {
      chars[index] = '9';
    } else {
      chars[index]--;
    }
    return new String(chars);
  }

  /**
   * 在知道终点的情况下，可以双向广搜，使用hashset替换队列，便于两个搜索方向的比较
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int openLock2(String[] deadends, String target) {
    // 正向搜索
    Set<String> set1 = new HashSet<>();
    set1.add("0000");
    // 反向搜索
    Set<String> set2 = new HashSet<>();
    set2.add(target);
    Set<String> visit = new HashSet<>(Arrays.asList(deadends));
    int step = 0;

    while (!set1.isEmpty() && !set2.isEmpty()) {
      // 优先扩大搜索方向元素较少的，便于快速找到target
      if (set1.size() > set2.size()) {
        Set<String> tmp = set1;
        set1 = set2;
        set2 = tmp;
      }
      // set1的下一个搜索空间
      Set<String> nextSet = new HashSet<>();

      for (String wheels : set1) {
        if (set2.contains(wheels)) return step;

        if (!visit.contains(wheels)) {
          visit.add(wheels);
          for (int i = 0; i < 4; i++) {
            nextSet.add(rollUp(wheels, i));
            nextSet.add(rollDown(wheels, i));
          }
        }
      }

      set1 = nextSet;
      step++;
    }

    return -1;
  }
}
