package sqrtX;

public class Solution {
	int sqrt(int x) {
	     long i = 0;
	     long j = x / 2 + 1;
	    while (i <= j)
	    {
	        long mid = (i + j) / 2;
	        long sq = mid * mid;
	        if (sq == x) return (int)mid;
	        else if (sq < x) i = mid + 1;
	        else j = mid - 1;
	    }
	    return (int)j;
	}
}
