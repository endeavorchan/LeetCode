package shortestWordDistance3;

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (!word1.equals(word2)) {
        	int result = Integer.MAX_VALUE;
            int[] position = new int[2];
            position[0] = -1;
            position[1] = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1) && position[1] == -1) {
                    position[0] = i;
                } else if (words[i].equals(word1)) {
                    if (Math.abs(i - position[1]) < result) {
                        result = Math.abs(i - position[1]);
                    }
                    position[0] = i;
                } else if (words[i].equals(word2) && position[0] == -1) {
                    position[1] = i;
                }
                else if (words[i].equals(word2)) {
                    if (Math.abs(i - position[0]) < result) {
                        result = Math.abs(i - position[0]);
                    }
                    position[1] = i;
                }
            }
            return result;
        }
        else {
        	int result = Integer.MAX_VALUE;
        	int[] position = new int[2];
        	position[0] = -1;
        	position[1] = -1;
        	boolean isOdd = false;
        	
        	for (int i = 0; i < words.length; i++) {
        		if (words[i].equals(word1)) {
        			if (isOdd) {
        				position[0] = i;
        			}
        			else {
        				position[1] = i;
        			}
        			isOdd = !isOdd;
        			if (!(position[0] == -1 || (position[1] == -1)))
        				result = Math.min(result, Math.abs(position[0] - position[1]));
        		}
        	}
        	return result;
        }
        
    }
}