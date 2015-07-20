package medianOfTwoArray4;

import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int size_a = (nums1 == null) ? 0 : nums1.length;
    	int size_b = (nums2 == null) ? 0 : nums2.length;
    	int left = (size_a + size_b + 1) / 2;
    	int right = (size_a + size_b + 2) / 2;
    	System.out.println("left is " + left);
    	System.out.println("right is " + right);
        return ((find_kth(nums1, nums2, size_a, size_b, left) +
        		find_kth(nums1, nums2,size_a, size_b, right)) / 2) ;
    }
    public double find_kth(int[] a, int[] b,int size_a, int size_b, int k) {
    	if (size_a > size_b)
    		return find_kth(b, a, size_b, size_a, k);
    	if (size_a == 0 && size_b > 0) {
    		return b[k - 1];
    	}
    	if (k == 1)
    		return Math.min(a[0], b[0]);
    	int i = Math.min(size_a, k/2);
    	int j = Math.min(size_b, k/2);
//    	if (a[i-1] == b[j-1]) {
//    		int[] newB = Arrays.copyOfRange(b, j - 1, b.length);
//    		return find_kth(a, newB, i  , size_b -j - 1, k - j - 1);
//    	}
    	if (a[i-1] > b[j-1]) {
    		int[] newB = Arrays.copyOfRange(b, j, b.length);
    		size_a = a.length == i ? i : i + 1;
    		return find_kth(a, newB, size_a , size_b -j, k - j);
    	}
    	else {
    		int[] newA = Arrays.copyOfRange(a, i, a.length);
    		size_b = b.length == j ? j : j + 1;
    		return find_kth(newA, b, size_a - i, size_b,  k - i);
    	}
    	
    }
}