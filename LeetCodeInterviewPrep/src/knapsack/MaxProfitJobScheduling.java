package knapsack;

import java.util.Arrays;

public class MaxProfitJobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Job {
		int start;
		int end;
		int profit;

		public Job(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}
//knapsack where you take or leave an element in ans path based on cond.
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int n = profit.length;
		Job arr[] = new Job[n];
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Job(startTime[i], endTime[i], profit[i]);
			dp[i] = -1;
		}

		Arrays.sort(arr, (a, b) -> a.start == b.end ? a.end - b.end : a.start - b.start);
		
		return helper(arr,dp,0);
		
	}
	
		int helper(Job[] arr,int [] dp, int idx) {
			
			if(idx>=arr.length) {
				return 0;
			}
			
			if(dp[idx]!=-1) {
				return dp[idx];
			}
			
			int j=idx+1;
			
			while(j<arr.length && arr[j].start< arr[idx].end) {
				j++;
			}
			
			return dp[idx]=Math.max(helper(arr,dp,j)+arr[idx].profit, helper(arr, dp, idx+1));
			
			
		}

}
