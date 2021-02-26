package com.wzx.leetcode;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/network-delay-time/">https://leetcode.com/problems/network-delay-time/</a>
 */
public class No743NetworkDelayTime {

  /**
   * Dijkstra
   * <p>
   * time: O((E+V)logV)
   * space: O(V)
   */
  public int networkDelayTime1(int[][] times, int n, int k) {
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    // 起点->边
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge : times) {
      graph.putIfAbsent(edge[0], new LinkedList<>());
      graph.get(edge[0]).add(edge);
    }
    // 顶点的最小堆, 存放更新好最短距离却没有更新其他顶点最短距离的顶点
    // (point, distance)
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue));
    // 添加源点
    queue.add(new AbstractMap.SimpleEntry<>(k, 0));
    dist[k] = 0;
    dist[0] = 0;
    // 标记更新好最短距离的顶点
    boolean[] visit = new boolean[n + 1];
    // 从源点出发, 更新到其他点的最短距离
    while (!queue.isEmpty()) {
      int point = queue.poll().getKey();
      // 优先队列中可能包含重复元素, 防止重复
      if (visit[point]) continue;
      visit[point] = true;
      // 访问point的所有出边
      List<int[]> edges = graph.getOrDefault(point, Collections.emptyList());
      for (int[] edge : edges) {
        int next = edge[1], time = edge[2];
        if (visit[next]) continue;
        // origin -> next => min(point -> next + origin -> point)
        dist[next] = Math.min(dist[next], dist[point] + time);
        // 这里没有删除旧的next结点, 因为新的next总比旧的先访问, 由于visit数组的标记, 旧结点将被跳过
        queue.add(new AbstractMap.SimpleEntry<>(next, dist[next]));
      }
    }

    int res = Arrays.stream(dist).max().getAsInt();
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  /**
   * Floyd
   * <p>
   * time: O(V^3)
   * space: O(V^2)
   */
  public int networkDelayTime2(int[][] times, int n, int k) {
    // 邻接矩阵
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) dist[i][j] = Integer.MAX_VALUE;
      }
    }
    // 更新直接路径
    for (int[] edge : times) {
      dist[edge[0] - 1][edge[1] - 1] = edge[2];
    }
    // 用每个顶点作为中间点更新原两点间的路径
    for (int v = 0; v < n; v++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          // 防止溢出
          if (dist[i][v] == Integer.MAX_VALUE || dist[v][j] == Integer.MAX_VALUE) continue;
          dist[i][j] = Math.min(dist[i][j], dist[i][v] + dist[v][j]);
        }
      }
    }

    int res = Arrays.stream(dist[k - 1]).max().getAsInt();
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
