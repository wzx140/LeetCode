package com.wzx.leetcode;

import com.wzx.entity.UF;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">https://leetcode.com/problems/min-cost-to-connect-all-points/</a>
 */
public class No1584MinCostToConnectAllPoints {

  /**
   * Prime算法
   * <p>
   * time: O((E+V)logV)
   * space: O(V)
   */
  public int minCostConnectPoints1(int[][] points) {
    int n = points.length;
    // 顶点的最小堆, 存放更新好最短距离却没有更新其他顶点最短距离的顶点
    // (顶点编号, distance)
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue));
    // 添加源点
    queue.add(new AbstractMap.SimpleEntry<>(0, 0));
    // 标记更新好最短距离的顶点
    boolean[] visit = new boolean[n];
    int res = 0;
    // 从源点出发, 更新到其他点的最短距离
    while (!queue.isEmpty()) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      int point = entry.getKey();
      int dist = entry.getValue();
      // 优先队列中可能包含重复元素, 防止重复
      if (visit[point]) continue;
      visit[point] = true;
      res += dist;
      // 访问point的所有出边
      for (int next = 0; next < n; next++) {
        if (visit[next]) continue;
        // 这里没有删除旧的next结点, 因为新的next总比旧的先访问, 由于visit数组的标记, 旧结点将被跳过
        queue.add(new AbstractMap.SimpleEntry<>(next,
                Math.abs(points[point][0] - points[next][0]) + Math.abs(points[point][1] - points[next][1])));
      }
    }

    return res;
  }

  /**
   * Kruskal算法
   * <p>
   * time: O(ElogE+Vlog*E)
   * space: O(V+E)
   */
  public int minCostConnectPoints2(int[][] points) {
    List<int[]> inputEdge = new LinkedList<>();
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
        inputEdge.add(new int[]{i, j, dist});
      }
    }
    return kruskal(inputEdge.toArray(new int[inputEdge.size()][]), points.length);
  }

  /**
   * @param inputEdges: 有向边集合{{start, end, weight}}
   * @param n:          顶点个数
   * @return 最小生成树的路径和
   */
  private int kruskal(int[][] inputEdges, int n) {
    // 并查集, 标记mst的连通关系
    UF uf = new UF(n);
    int res = 0, num = 0;
    // 排序, 每次尝试加入最小的边
    Arrays.sort(inputEdges, Comparator.comparingInt(x -> x[2]));
    for (int[] edge : inputEdges) {
      // 边的两点连接了两个相异的连通块则可以加入mst, 否则会在mst中形成环
      if (!uf.isConnect(edge[0], edge[1])) {
        res += edge[2];
        num++;
        // mst中已有全部结点
        if (num == n) break;
        // 记录边的连通关系
        uf.union(edge[0], edge[1]);
      }
    }

    return res;
  }
}
