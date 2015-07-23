package candy;

public class Solution {
	public int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		for (int i = 0; i < candy.length; i++)
			candy[i] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candy[i] = candy[i - 1] + 1;
		}
		int result = candy[candy.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			int curr = 1;
			if (ratings[i] > ratings[i + 1])
				curr = candy[i + 1] + 1;
			result += Math.max(curr, candy[i]);
			candy[i] = Math.max(curr,candy[i]);
			
		}
		
		return result;
	}
}
