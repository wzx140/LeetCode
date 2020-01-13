package introduce.string;

import org.junit.Test;
import per.wzx.introduce.string.AddBinary;

import static org.junit.Assert.*;

public class AddBinaryTest {
    private AddBinary addBinary = new AddBinary();

    @Test
    public void addBinary1Test() {
        String res1 = addBinary.addBinary1("11", "1");
        String res2 = addBinary.addBinary1("1010", "1011");
        String res3 = addBinary.addBinary1("1111", "1");
        assertEquals("100", res1);
        assertEquals("10101", res2);
        assertEquals("10000", res3);
    }

    @Test
    public void addBinary2Test() {
        String res1 = addBinary.addBinary2("11", "1");
        String res2 = addBinary.addBinary2("1010", "1011");
        String res3 = addBinary.addBinary2("1111", "1");
        assertEquals("100", res1);
        assertEquals("10101", res2);
        assertEquals("10000", res3);
    }
}