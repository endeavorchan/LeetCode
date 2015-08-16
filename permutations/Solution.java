package permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (List<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<List<Integer>>(current);
		}
	 
		return result;
	}

}
