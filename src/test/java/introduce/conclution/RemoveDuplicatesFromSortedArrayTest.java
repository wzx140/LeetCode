package introduce.conclution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayTest {
    private RemoveDuplicatesFromSortedArray dup = new RemoveDuplicatesFromSortedArray();

    @Test
    public void removeDuplicatesTest() {
        int[] nums1 = {1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int length1 = dup.removeDuplicates(nums1);
        assertEquals(2, length1);
        assertEquals(1, nums1[0]);
        assertEquals(2, nums1[1]);

        int length2 = dup.removeDuplicates(nums2);
        assertEquals(5, length2);
        assertEquals(0, nums2[0]);
        assertEquals(1, nums2[1]);
        assertEquals(2, nums2[2]);
        assertEquals(3, nums2[3]);
        assertEquals(4, nums2[4]);
    }
}