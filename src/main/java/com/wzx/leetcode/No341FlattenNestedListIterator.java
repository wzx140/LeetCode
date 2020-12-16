package com.wzx.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * @author wzx
 */
public class No341FlattenNestedListIterator {

  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
  }

  public static class NestedIntegerImpl implements NestedInteger {

    private Integer val = null;
    private List<NestedInteger> list = null;

    public NestedIntegerImpl(Integer val) {
      this.val = val;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
      this.list = list;
    }

    @Override
    public boolean isInteger() {
      return val != null;
    }

    @Override
    public Integer getInteger() {
      return val;
    }

    @Override
    public List<NestedInteger> getList() {
      return list;
    }
  }

  public static class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> NestedIntegerList = null;

    public NestedIterator(List<NestedInteger> nestedList) {
      NestedIntegerList = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
      return NestedIntegerList.pollFirst().getInteger();
    }

    /**
     * 不断flat list中第一个NestedInteger, 直到list中第一个NestedInteger为数字
     */
    @Override
    public boolean hasNext() {
      while (!NestedIntegerList.isEmpty() && !NestedIntegerList.getFirst().isInteger()) {
        List<NestedInteger> integers = NestedIntegerList.pollFirst().getList();
        NestedIntegerList.addAll(0, integers);
      }

      return !NestedIntegerList.isEmpty();
    }

  }


}
