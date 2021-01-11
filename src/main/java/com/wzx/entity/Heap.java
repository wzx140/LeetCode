package com.wzx.entity;

import java.util.Collection;
import java.util.Comparator;

public class Heap<E> {
  private final Object[] heap;
  private int size = 0;
  private final Comparator<? super E> comparator;

  public Heap(int size, Comparator<? super E> comparator) {
    heap = new Object[size];
    this.comparator = comparator;
  }

  public Heap(Collection<E> data, Comparator<? super E> comparator) {
    this.heap = data.toArray(new Object[0]);
    this.size = data.size();
    this.comparator = comparator;
    // 筛选法建堆, 由下往上调用siftDown
    // 最后一个分支结点下标为 n/2
    for (int i = size / 2 - 1; i >= 0; i--) {
      siftDown(i);
    }
  }

  public int size() {
    return size;
  }

  public void add(E val) {
    heap[size] = val;
    siftUp(size);
    size++;
  }

  public void pop() {
    size--;
    heap[0] = heap[size];
    siftDown(0);
  }

  public E peek() {
    return (E) heap[0];
  }

  /**
   * 从第i个结点向下调整
   */
  private void siftDown(int i) {
    int parent = i;
    // i结点暂存
    E record = (E) heap[parent];
    // 左子结点
    int child = 2 * parent + 1;
    while (child < size) {
      // 取左右子结点中较小的
      if (child + 1 < size && comparator.compare((E) heap[child + 1], (E) heap[child]) < 0) {
        child = child + 1;
      }
      // 当前结点大于子结点则向下传播
      if (comparator.compare(record, (E) heap[child]) > 0) {
        heap[parent] = heap[child];
      } else {
        break;
      }
      // 更新结点索引
      parent = child;
      child = 2 * parent + 1;
    }
    heap[parent] = record;
  }

  /**
   * 从第i个结点向上调整
   */
  private void siftUp(int i) {
    int child = i;
    // i结点暂存
    E record = (E) heap[child];
    // 父结点
    int parent = (child - 1) / 2;
    // 防止出现child=parent的死循环
    while (child > 0) {
      // 当前结点小于父结点则将当前结点向上传播
      if (comparator.compare(record, (E) heap[parent]) < 0) {
        // 给当前结点留出空位
        heap[child] = heap[parent];
      } else {
        break;
      }
      // 更新结点索引
      child = parent;
      parent = (child - 1) / 2;
    }
    heap[child] = record;
  }
}
