package introduce.conclution;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {


    public List<Integer> getRow(int rowIndex) {
        int length = rowIndex + 1;
        int[] res = new int[length];

        res[0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 1; j--) {
                res[j] += res[j - 1];
            }
        }
        List<Integer> resList = new ArrayList<>(length);
        for (int num : res) {
            resList.add(num);
        }
        return resList;
    }
}
