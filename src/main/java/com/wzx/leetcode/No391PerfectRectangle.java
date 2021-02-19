package com.wzx.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/perfect-rectangle/">https://leetcode.com/problems/perfect-rectangle/</a>
 * @author wzx
 */
public class No391PerfectRectangle {

  /**
   * 1. 确定4个顶点
   * 2. 判断面积是否一致
   * 3. 检查角点(重合数为奇数)是否是四个, 且对应四个顶点, 因为完美矩形的角点有且只有4个
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public boolean isRectangleCover(int[][] rectangles) {
    int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
    int area = 0;
    Set<List<Integer>> corners = new HashSet<>();
    for (int[] rectangle : rectangles) {
      int rX1 = rectangle[0];
      int rY1 = rectangle[1];
      int rX2 = rectangle[2];
      int rY2 = rectangle[3];
      // 确定4个顶点
      x1 = Math.min(x1, rX1);
      y1 = Math.min(y1, rY1);
      x2 = Math.max(x2, rX2);
      y2 = Math.max(y2, rY2);
      List<Integer> rLeftUp = Arrays.asList(rX1, rY1);
      List<Integer> rLeftDown = Arrays.asList(rX1, rY2);
      List<Integer> rRightUp = Arrays.asList(rX2, rY1);
      List<Integer> rRightDown = Arrays.asList(rX2, rY2);
      // 提取角点
      if (corners.contains(rLeftUp)) {
        corners.remove(rLeftUp);
      } else {
        corners.add(rLeftUp);
      }
      if (corners.contains(rLeftDown)) {
        corners.remove(rLeftDown);
      } else {
        corners.add(rLeftDown);
      }
      if (corners.contains(rRightUp)) {
        corners.remove(rRightUp);
      } else {
        corners.add(rRightUp);
      }
      if (corners.contains(rRightDown)) {
        corners.remove(rRightDown);
      } else {
        corners.add(rRightDown);
      }
      // 计算总面积
      area += (rX2 - rX1) * (rY2 - rY1);
    }
    // 1. 4个顶点
    List<Integer> leftUp = Arrays.asList(x1, y1);
    List<Integer> leftDown = Arrays.asList(x1, y2);
    List<Integer> rightUp = Arrays.asList(x2, y1);
    List<Integer> rightDown = Arrays.asList(x2, y2);
    // 2. 面积是否一致
    if (area != (x2 - x1) * (y2 - y1)) return false;
    // 3. 角点是否和4个顶点一致
    if (corners.size() != 4) return false;
    if (!corners.contains(leftUp)) return false;
    if (!corners.contains(leftDown)) return false;
    if (!corners.contains(rightUp)) return false;
    if (!corners.contains(rightDown)) return false;

    return true;
  }
}
