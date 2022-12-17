package stack;

import java.util.Stack;

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ["MyQueue","push","push","peek","pop","empty"] [[],[1],[2],[],[],[]]
		 */

		
		ImplementQueueUsingStack obj=new ImplementQueueUsingStack();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

	Stack<Integer> stA;
	Stack<Integer> stB;

	public ImplementQueueUsingStack() {
	    stA=new Stack();
	    stB=new Stack();
	    
	    }

	public void push(int x) {
		stA.push(x);
	}

	public int pop() {
		if (!stB.isEmpty()) {
			return stB.pop();
		} else {
			int size=stA.size();
			for (int i = 0; i < size; i++) {
				stB.push(stA.pop());
			}
			return stB.pop();
		}

	}

	public int peek() {
		if (!stB.isEmpty()) {
			return stB.peek();
		} else {
			int size=stA.size();
			for (int i = 0; i < size; i++) {
				stB.push(stA.pop());
			}
			return stB.peek();
		}
	}

	public boolean empty() {
		if (stA.isEmpty() && stB.isEmpty()) {
			return true;
		}
		return false;
	}

}
