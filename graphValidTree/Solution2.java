package graphValidTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> linked = new HashSet<Integer>();
        Set<Integer> unlinked = new HashSet<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        List<Integer> last = new ArrayList<Integer>();
        List<Integer> current = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
        	unlinked.add(i);
        }
        
        for (int[] edge : edges) {
        	List<Integer> list;
        	if (map.containsKey(edge[0])) {
        	    list = map.get(edge[0]);
        		list.add(edge[1]);
        	} else {
        		list = new ArrayList<Integer>();
        		list.add(edge[1]);
        		
        	}
        	map.put(edge[0], list);
        }
        System.out.println(map.toString());
        
        //set 0 as start; 
        linked.add(0);
        unlinked.remove(0);
        last.add(0);
        
        while (last.size() > 0) {
        	current.clear();
        	for (int start : last) {
        		if (map.get(start) == null) 
        			continue;
        		for (int target : map.get(start)) {
        			if (linked.contains(target)) {
        				return false;
        			}
        			linked.add(target);
        			current.add(target);
        			unlinked.remove(target);
        		}
        		map.remove(start);
        		System.out.println(map.toString());
        		
        	}
        	last.clear();
        	last.addAll(current);
        }
        
        if (unlinked.size() > 0)
        	return false;
        return true;
    }
}