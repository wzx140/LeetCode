package com.wzx.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106
 *
 * @author wzx
 */
public class No25StackSequence {

  public static boolean IsPopOrder(int[] pushA, int[] popA) {
    if (pushA.length != popA.length) return false;

    Deque<Integer> stack = new ArrayDeque<>(pushA.length);
    int pushIndex = 0;
    int popIndex = 0;
    while (pushIndex < pushA.length) {
      if (pushA[pushIndex] != popA[popIndex]) {
        // 如果不相等，说明当前操作为压栈
        stack.push(pushA[pushIndex++]);
      } else {
        // 如果相等，说明当前操作为先压栈紧接着开始弹栈
        pushIndex++;
        popIndex++;
        while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
          stack.pop();
          popIndex++;
        }
      }
    }

    return stack.isEmpty();
  }
}
