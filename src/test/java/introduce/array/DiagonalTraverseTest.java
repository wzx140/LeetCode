package introduce.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import per.wzx.introduce.array.DiagonalTraverse;

public class DiagonalTraverseTest {
    private int[][] a = {{1, 2, 3, 4, 5}};
    private int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private DiagonalTraverse diagonalTraverse = new DiagonalTraverse();

    @Test
    public void findDiagonalOrder1Test() {
        int[] res1 = diagonalTraverse.findDiagonalOrder1(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, res1);

        int[] res2 = diagonalTraverse.findDiagonalOrder1(b);
        assertArrayEquals(new int[]{1,2,4,7,5,3,6,8,9},res2);
    }

    @Test
    public void findDiagonalOrder2Test() {
        int[] res1 = diagonalTraverse.findDiagonalOrder2(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, res1);

        int[] res2 = diagonalTraverse.findDiagonalOrder2(b);
        assertArrayEquals(new int[]{1,2,4,7,5,3,6,8,9},res2);
    }
}