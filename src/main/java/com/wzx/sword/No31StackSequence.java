package com.wzx.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/">https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/</a>
 * @author wzx
 */
public class No31StackSequence {

  /**
   * 使用栈判断
   * time: O(n)
   * space: O(n)
   */
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Deque<Integer> stack = new LinkedList<>();
    int pushIndex = 0, popIndex = 0;
    while(pushIndex < pushed.length || !stack.isEmpty()){
      if(stack.isEmpty() || (pushIndex < pushed.length && stack.peekFirst() != popped[popIndex])){
        // 栈为空或者不符合弹栈条件时, 压栈
        stack.addFirst(pushed[pushIndex]);
        pushIndex++;
      }else if(stack.peekFirst() == popped[popIndex]){
        // 符合条件即弹栈
        stack.removeFirst();
        popIndex++;
      }else{
        // 即没有压栈的元素, 也不符合弹栈条件
        return false;
      }
    }

    return true;
  }
}
