package medianOfTwoArray4;

import static org.junit.Assert.*;

import org.junit.Test;

public class testSol {
	static Solution sol = new Solution();
	@Test
	public void test() {
		int[] a = {1, 3, 4};
		int[] b = {1, 3, 4};
		System.out.println(sol.findMedianSortedArrays(a, b));
	}
	
	@Test
	public void test2() {
		int[] a = {};
		int[] b = {1};
		System.out.println(sol.findMedianSortedArrays(a, b));
	}
	
	@Test
	public void test3() {
		int[] a = {1};
		int[] b = {2, 3, 4};
		System.out.println(sol.findMedianSortedArrays(a, b));
	}
	
	@Test
	public void test4() {
		int[] a = {1, 1};
		int[] b = {1, 2};
		System.out.println(sol.find_kth(a, b, 2, 2, 3));
		//System.out.println(sol.findMedianSortedArrays(a, b));
	}
}
