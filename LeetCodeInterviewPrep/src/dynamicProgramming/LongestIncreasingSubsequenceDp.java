package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequenceDp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLIS(int[] nums) {

		int dp[] = new int[nums.length];
		int ans = 1;
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}

			}
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}
}
