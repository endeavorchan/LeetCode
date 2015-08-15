package implementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> temp = new Stack<Integer>();
	Stack<Integer> value = new Stack<Integer>();
	
	public void push(int x) {
		if (value.isEmpty()) {
			value.push(x);
		} else {
			while (!value.isEmpty()) {
				temp.push(value.pop());
			}
			
			value.push(x);
			
			while (!temp.isEmpty()) {
				value.push(temp.pop());
			}
		}
	}
	
	public void pop() {
		value.pop();
	}
	
	public int peek() {
		return value.peek();
	}
	
	public boolean empty() {
		return value.isEmpty();
	}
	
}
