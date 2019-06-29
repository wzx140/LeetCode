package main.java.introduce.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new ArrayList<Integer>();
        }
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>(row * column);
        // 当前索引
        int[] next = { 0, 0 };
        // 0->右 1->下 2->左 3->上
        int mode = 0;
        // 当前边界
        int[] boundary = { column - 1, row - 1, 0, 1 };

        for (int i = 0; i < row * column; i++) {
            int x = next[0];
            int y = next[1];
            res.add(matrix[x][y]);
            next = nextIndex(x, y, boundary, mode);
            if (next != null) {
                x = next[0];
                y = next[1];
            } else {
                // 改变方向
                mode = nextMode(mode);
                if (mode == 0) {
                    // 当四个方向都完成时，边界缩小1
                    boundary[0] -= 1;
                    boundary[1] -= 1;
                    boundary[2] += 1;
                    boundary[3] += 1;
                }
                next = nextIndex(x, y, boundary, mode);
            }
        }
        return res;
    }

    private int[] nextIndex(int x, int y, int[] boundary, int mode) {
        switch (mode) {
        case 0:
            // 右
            if (y == boundary[0]) {
                return null;
            } else {
                return new int[] { x, y + 1 };
            }
        case 1:
            // 下
            if (x == boundary[1]) {
                return null;
            } else {
                return new int[] { x + 1, y };
            }
        case 2:
            // 左
            if (y == boundary[2]) {
                return null;
            } else {
                return new int[] { x, y - 1 };
            }
        case 3:
            // 上
            if (x == boundary[3]) {
                return null;
            } else {
                return new int[] { x - 1, y };
            }
        default:
            return null;
        }
    }

    private int nextMode(int mode) {
        if (mode != 3) {
            return mode + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println(res);
    }
}