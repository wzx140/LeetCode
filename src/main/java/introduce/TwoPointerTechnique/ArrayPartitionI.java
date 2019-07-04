package main.java.introduce.TwoPointerTechnique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        // sort
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        Collections.sort(temp);

        int sum = 0;
        // Adjacent elements as a group
        for (int i = 0; i < temp.size(); i += 2) {
            sum += temp.get(i) < temp.get(i + 1) ? temp.get(i) : temp.get(i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 6, 2};
        ArrayPartitionI solution = new ArrayPartitionI();
        System.out.println(solution.arrayPairSum(nums));
    }
}
