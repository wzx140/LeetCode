package introduce.conclution;

import org.junit.Test;
import per.wzx.introduce.conclution.MoveZeroes;

import static org.junit.Assert.*;

public class MoveZeroesTest {
    private MoveZeroes moveZeroes = new MoveZeroes();
    private int[] a = {0, 1, 0, 3, 12};

    @Test
    public void moveZeroes1Test() {
        moveZeroes.moveZeroes1(a);
        assertEquals(1, a[0]);
        assertEquals(3, a[1]);
        assertEquals(12, a[2]);
        assertEquals(0, a[3]);
        assertEquals(0, a[4]);
    }

    @Test
    public void moveZeroes2Test() {
        moveZeroes.moveZeroes2(a);
        assertEquals(1, a[0]);
        assertEquals(3, a[1]);
        assertEquals(12, a[2]);
        assertEquals(0, a[3]);
        assertEquals(0, a[4]);
    }
}