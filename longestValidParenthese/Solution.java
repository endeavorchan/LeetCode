package longestValidParenthese;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int[] closed = new int[s.length()];
        Stack<Point> stack = new Stack<Point>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(new Point(i, c));
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.size() != 0 && stack.peek().c == complement(c)) {
                        closed[stack.peek().i] = i;
                        stack.pop();
                    }
                    else {
                        stack.clear();
                    }
                    break;
            }
            
        }
        int currentLength = 0;;
        int maxLength = 0;
        for (int i = 0; i < closed.length; i++) {
            if (closed[i] == 0) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    
                }
                currentLength = 0;
            }
            else {
                currentLength += closed[i] - i + 1;
                i = closed[i];
            }
        }
        if (currentLength > maxLength)
        	maxLength = currentLength;
        return maxLength;
        
    }
    
    public char complement(char c) {
        if (c == ')')
            return '(';
        if (c == ']')
            return '[';
        if (c == '}')
            return '{';
        return c;
    }
}

class Point {
    int i;
    char c;
    Point(int i, char c) {
        this.i = i;
        this.c = c;
    }
}