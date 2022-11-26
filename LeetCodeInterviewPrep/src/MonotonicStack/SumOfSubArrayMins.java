package MonotonicStack;

import java.util.Stack;

public class SumOfSubArrayMins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int MOD = 1000000007;

	public int sumSubarrayMins(int[] arr) {

		Stack<Integer> stack = new Stack();

		long ans = 0;

		for (int i = 0; i < arr.length; i++) {
			// using a mono stack to get the right boundary of element
			// stack only keeps increasing element so any element smaller than stack peek
			// gets
			// you the right boundary while the element before this peek element gets you
			// the left boundary. Now you can calculate the number of such subarrays where
			// this
			// peek element will be min.
			while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
				int index = stack.pop();
				int left = stack.empty() ? -1 : stack.peek();
				int right = i;
				long c = ((index - left) * (right - index)) % MOD;
				ans += (c * arr[index]) % MOD;
				ans %= MOD;
			}
			stack.push(i);
		}
		return (int) ans;
	}
}
