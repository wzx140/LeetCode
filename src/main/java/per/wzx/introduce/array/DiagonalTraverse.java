package per.wzx.introduce.array;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
 */
public class DiagonalTraverse {
    /**
     * 1. Two array 'up' and 'down' record 'up-right' and 'left-down' outer
     * element's index separately 2. The element in array 'up' and 'down' is as a
     * starting point alternately
     */
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int diagonal = column + row - 1;
        int[] res = new int[row * column];

        int[][] up = new int[diagonal][2];
        for (int i = 0; i < row; i++) {
            up[i][0] = i;
            up[i][1] = 0;
        }
        int temp = row;
        for (int i = 1; i < column; i++) {
            up[temp][0] = row - 1;
            up[temp][1] = i;
            temp++;
        }

        int[][] down = new int[diagonal][2];
        for (int i = 0; i < column; i++) {
            down[i][0] = 0;
            down[i][1] = i;
        }
        temp = column;
        for (int i = 1; i < row; i++) {
            down[temp][0] = i;
            down[temp][1] = column - 1;
            temp++;
        }

        int x = 0;
        int y = 0;
        boolean reverse = false;
        int index = 0;
        for (int i = 0; i < diagonal; i++) {
            if (reverse) {
                x = down[i][0];
                y = down[i][1];
                while (x <= row - 1 && y >= 0) {
                    res[index] = matrix[x][y];
                    x++;
                    y--;
                    index++;
                }
                reverse = false;
            } else {
                x = up[i][0];
                y = up[i][1];
                while (y <= column - 1 && x >= 0) {
                    res[index] = matrix[x][y];
                    x--;
                    y++;
                    index++;
                }
                reverse = true;
            }
        }
        return res;
    }

    /**
     * Two loops in findDiagonalOrder1 can be one loop instead because I found new
     * way to get start point.
     */
    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int diagonal = column + row - 1;
        int[] res = new int[row * column];

        int x = 0;
        int y = 0;
        boolean reverse = false;
        int index = 0;
        for (int i = 0; i < diagonal; i++) {
            if (reverse) {
                // down
                while (true) {
                    res[index] = matrix[x][y];
                    index++;
                    if (x == row - 1 || y == 0) {
                        break;
                    }
                    x++;
                    y--;
                }
                reverse = false;
                // next start point
                if (x < row - 1) {
                    x += 1;
                } else {
                    y += 1;
                }
            } else {
                // up
                while (true) {
                    res[index] = matrix[x][y];
                    index++;
                    if (x == 0 || y == column - 1) {
                        break;
                    }
                    x--;
                    y++;
                }
                reverse = true;
                // next start point
                if (y < column - 1) {
                    y += 1;
                } else {
                    x += 1;
                }
            }
        }
        return res;
    }
}