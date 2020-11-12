package com.wzx.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * @author wzx
 */
public class No310MinimumHeightTrees {

  /**
   * 哈希表, 超时
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
    // edge的两端的哈希表
    Map<Integer, List<Integer>> edgesMap = new HashMap<>();
    Map<Integer, List<Integer>> invertedEdgesMap = new HashMap<>();
    for (int[] edge : edges) {
      int edge1 = edge[0];
      int edge2 = edge[1];

      if (!edgesMap.containsKey(edge1)) edgesMap.put(edge1, new LinkedList<>());
      edgesMap.get(edge1).add(edge2);

      if (!invertedEdgesMap.containsKey(edge2)) invertedEdgesMap.put(edge2, new LinkedList<>());
      invertedEdgesMap.get(edge2).add(edge1);
    }

    int minHeight = Integer.MAX_VALUE;
    List<Integer> res = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      visited.clear();
      int height = getHeight(i, edgesMap, invertedEdgesMap, visited);
      if (minHeight > height) {
        res.clear();
        res.add(i);
        minHeight = height;
      } else if (minHeight == height) {
        res.add(i);
      }
    }
    return res;
  }

  private int getHeight(int root,
                        Map<Integer, List<Integer>> edgesMap,
                        Map<Integer, List<Integer>> invertedEdgesMap,
                        Set<Integer> visited) {
    visited.add(root);

    // root所有未访问过的子结点
    List<Integer> children = Stream.concat(edgesMap.getOrDefault(root, Collections.emptyList()).stream(),
            invertedEdgesMap.getOrDefault(root, Collections.emptyList()).stream())
            .filter(node -> !visited.contains(node))
            .collect(Collectors.toList());

    // 递归遍历
    int height = 0;
    for (Integer child : children) {
      if (!visited.contains(child)) {
        height = Math.max(height, getHeight(child, edgesMap, invertedEdgesMap, visited));
      }
    }
    return height + 1;
  }

  /**
   * 利用拓扑排序找出质心, 质心即MHT的根结点
   * https://leetcode.com/problems/minimum-height-trees/solution/
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
    if (n < 2) {
      return Collections.singletonList(0);
    }

    // 初始化图
    List<Set<Integer>> neighbour = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      neighbour.add(new HashSet<>());
    }
    for (int[] edge : edges) {
      int start = edge[0], end = edge[1];
      neighbour.get(start).add(end);
      neighbour.get(end).add(start);
    }

    // 初始化叶结点列表
    List<Integer> leafList = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (neighbour.get(i).size() == 1) leafList.add(i);
    }

    // 广搜质心
    // 题解中有证明，质心最多只有两个
    int remainNode = n;
    while (remainNode > 2) {
      remainNode -= leafList.size();
      List<Integer> newLeafList = new LinkedList<>();
      for (int leaf : leafList) {
        // 删除叶结点的edge
        int node = neighbour.get(leaf).iterator().next();
        neighbour.get(node).remove(leaf);
        // 判断删除后node是否变为叶结点
        if (neighbour.get(node).size() == 1) {
          newLeafList.add(node);
        }
      }
      leafList = newLeafList;
    }

    return leafList;
  }
}
