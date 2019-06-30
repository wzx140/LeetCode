package main.java.introduce.array;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
 */
class PascalTraiangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> preRow = new ArrayList<Integer>(1);
        List<Integer> currRow = null;
        // the first and last elements of the row is always 1
        preRow.add(1);
        res.add(preRow);
        for (int i = 1; i < numRows; i++) {
            currRow = new ArrayList<Integer>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(preRow.get(j - 1) + preRow.get(j));
            }
            currRow.add(1);
            res.add(currRow);
            preRow = currRow;
        }
        return res;
    }

    public static void main(String[] args) {
        PascalTraiangle pascalTraiangle = new PascalTraiangle();
        System.out.println(pascalTraiangle.generate(5));
    }
}