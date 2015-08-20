package shortestWordDistance;

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
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
}