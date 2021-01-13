package com.wzx.entity;

import java.util.Arrays;

public class UF {
  private final int[] parent;
  private final int[] count;

  public UF(int size) {
    this.parent = new int[size];
    this.count = new int[size];
    Arrays.fill(this.count, 1);
    for (int i = 0; i < size; i++) {
      this.parent[i] = i;
    }
  }

  private int find(int x) {
    if (parent[x] == x) return x;
    // 压缩结点到根结点的路径
    parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    int xRoot = find(x);
    int yRoot = find(y);
    if (xRoot == yRoot) return;

    if (count[xRoot] > count[yRoot]) {
      int tmp = x;
      x = y;
      y = tmp;
    }
    // 小的树合并到大的树上
    parent[yRoot] = xRoot;
    count[yRoot] += count[xRoot];
  }

  public boolean isConnect(int x, int y) {
    return find(x) == find(y);
  }
}
