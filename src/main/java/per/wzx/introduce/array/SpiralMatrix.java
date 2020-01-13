package per.wzx.introduce.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>(row * column);
        // current index
        int[] next = { 0, 0 };
        // 0->right 1->down 2->left 3->up
        int mode = 0;
        // current boundary
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
                // change mode(direct)
                mode = nextMode(mode);
                if (mode == 0) {
                    // shrink the boundary
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
            // right
            if (y == boundary[0]) {
                return null;
            } else {
                return new int[] { x, y + 1 };
            }
        case 1:
            // down
            if (x == boundary[1]) {
                return null;
            } else {
                return new int[] { x + 1, y };
            }
        case 2:
            // left
            if (y == boundary[2]) {
                return null;
            } else {
                return new int[] { x, y - 1 };
            }
        case 3:
            // up
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
}