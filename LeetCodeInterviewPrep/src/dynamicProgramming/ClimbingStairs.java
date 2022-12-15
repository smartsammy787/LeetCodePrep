package dynamicProgramming;

public class ClimbingStairs {
//70
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int climbStairs(int n) {

		int dp[] = new int[n + 1];
		dp[0] = 1; //question constraint 1->n  
		// also this follows fibonacci series like
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

}
