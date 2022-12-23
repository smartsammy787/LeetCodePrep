package dynamicProgramming;

class BestTimeToBuyStockWithCooldown {

	//309
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {

		Integer dp[][] = new Integer[prices.length][2];

		return helper(0, 0, prices, dp);
	}

	int helper(int idx, int hasStock, int prices[], Integer dp[][]) {
		int profit = 0;
		if (idx >= prices.length) {
			return 0;

		}
		if (dp[idx][hasStock] != null) {
			return dp[idx][hasStock];
		}

		if (hasStock == 0) {
			int buy = -prices[idx] + helper(idx + 1, 1, prices, dp);
			int doNothing = helper(idx + 1, 0, prices, dp);
			profit = Math.max(buy, doNothing);

		} else if (hasStock == 1) {

			int sell = prices[idx] + helper(idx + 2, 0, prices, dp);
			int doNothing = helper(idx + 1, hasStock, prices, dp);

			profit = Math.max(sell, doNothing);
		}

		return dp[idx][hasStock] = profit;
	}

}
