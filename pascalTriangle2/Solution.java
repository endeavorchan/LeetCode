package pascalTriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return null;
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if (rowIndex == 0)
            return result;
        for (int i = 1; i <= rowIndex; i++) {
            double temp = 1.0 * result.get(i - 1) * (rowIndex - i + 1) / i;
            result.add((int) temp);
        }
        
        return result;
    }
}