package introduce.TwoPointerTechnique;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RemoveElementTest {
    private RemoveElement removeElement = new RemoveElement();

    //    elements are like, regardless of order
    private boolean arrayEqual(int[] a, int length, int[] b) {
        List<Integer> bExclu = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (!bExclu.contains(j) && a[i] == b[j]) {
                    bExclu.add(j);
                    break;
                }
            }
        }
        if (bExclu.size() < length) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    public void removeElement1Test() {
        int[] a = {3, 2, 2, 3};
        int aVal = 3;
        int[] b = {0, 1, 2, 2, 3, 0, 4, 2};
        int bVal = 2;

        int length1 = removeElement.removeElement1(a, aVal);
        int length2 = removeElement.removeElement1(b, bVal);
        assertTrue(arrayEqual(a, length1, new int[]{2, 2}));
        assertTrue(arrayEqual(b, length2, new int[]{0, 1, 3, 0, 4}));
    }

    @Test
    public void removeElement2Test() {
        int[] a = {3, 2, 2, 3};
        int aVal = 3;
        int[] b = {0, 1, 2, 2, 3, 0, 4, 2};
        int bVal = 2;

        int length1 = removeElement.removeElement2(a, aVal);
        int length2 = removeElement.removeElement2(b, bVal);
        assertTrue(arrayEqual(a, length1, new int[]{2, 2}));
        assertTrue(arrayEqual(b, length2, new int[]{0, 1, 3, 0, 4}));
    }

}