package binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(queue.size() > 0) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode top = queue.remove();
        		if (i == 0) {
        			result.add(top.val);
        		}
        		if (top.right != null) {
        			queue.addFirst(top.right);
        		}
        		if (top.left != null) {
        			queue.add(top.left);
        		}
        	}
        }
        return result;
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { val = x; }
}