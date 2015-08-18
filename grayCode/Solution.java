package grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> grayCode(int n) {  
        if(n==0) {  
            List<Integer> result = new ArrayList<Integer>();  
            result.add(0);  
            return result;  
        }  
          
        List<Integer> result = grayCode(n-1);  
        int addNumber = 1 << (n-1);
        int originalsize=result.size();
        
        for(int i=originalsize-1;i>=0;i--) {  
            result.add(addNumber + result.get(i));  
        }  
        return result;  
    }
}
