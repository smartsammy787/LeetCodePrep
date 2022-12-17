package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		String tokens[] = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(obj.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() == 1 && (tokens[i].charAt(0) == '*' || tokens[i].charAt(0) == '+'
					|| tokens[i].charAt(0) == '-' || tokens[i].charAt(0) == '/')) {
				int exp = 0;
				int b = st.pop();
				int a = st.pop();
				switch (tokens[i]) {
				case "+":
					exp = a + b;
					break;
				case "-":
					exp = a - b;
					break;
				case "*":
					exp = a * b;
					break;
				case "/":
					exp = a / b;
					break;
				}
				st.push(exp);

			} else {
				int num = Integer.parseInt(tokens[i]);
				st.push(num);
			}
		}

		return st.pop();
	}
}
