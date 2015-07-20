package permutations2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2ProgramCreek {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			//return list hold permutation for i - 1 numbers. 
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}
		return returnList;
	}
}
