package com.wzx.entity;

public class UF {
  private final int[] parent;
  private final int[] count;

  public UF(int size) {
    parent = new int[size];
    count = new int[size];
    for (int i = 0; i < size; i++) {
      count[i] = 1;
      parent[i] = i;
    }
  }

  private int find(int node) {
    if (parent[node] == node) return node;
    // 压缩结点到根结点的路径
    parent[node] = find(parent[node]);
    return parent[node];
  }

  public void union(int node1, int node2) {
    int root1 = find(node1);
    int root2 = find(node2);
    if (root1 == root2) return;

    if (count[root1] > count[root2]) {
      int tmp = root1;
      root1 = root2;
      root2 = tmp;
    }
    // 小的树合并到大的树上
    parent[root1] = root2;
    count[root2] += count[root1];
  }

  public boolean isConnect(int node1, int node2) {
    return find(node1) == find(node2);
  }
}
