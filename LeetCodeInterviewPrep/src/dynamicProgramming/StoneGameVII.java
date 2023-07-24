package dynamicProgramming;

public class StoneGameVII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int prefixSum[];

	public int stoneGameVII(int[] stones) {
		int len = stones.length;

		prefixSum = new int[len + 1];

		for (int i = 0; i < len; i++) {
			prefixSum[i + 1] = prefixSum[i] + stones[i];

		}

		return helper(0, len - 1, new Integer[len][len]);
	}

	int getSum(int left, int right) {
		return prefixSum[right + 1] - prefixSum[left];
	}

//using minimax algorithm-AI 
	int helper(int left, int right, Integer[][] memo) {

		if (left == right) {
			return 0;
		}

		if (memo[left][right] != null) {
			return memo[left][right];
		}

		int curScoreRemoveLeft = getSum(left + 1, right);
		int curScoreRemoveRight = getSum(left, right - 1);
//both players trying to maximize their score

		// understanding
		// suppose n=5, then Alice's gain is a1+a3+a5 where a1 means the 1st round's
		// gain for Alice. Bob's gain is b2+b4. The final difference is
		// (a1+a3+a5)-(b2+b4) which can be rewritten as a1-(b2-(a3-(b4-a5))). If we
		// realize that a1>b2>a3>b4>a5, we know this is actually a recursive pattern.
		// The optimal strategy for both players is to maximize my_current_round_gain -
		// subproblem_difference. Alice wants to maximize a1-subproblem, so Alice wants
		// to maximize a3-subproblem due to the double negation. The same for Bob. Bob
		// wants to minimize a1-subproblem, so Bob wants to maximize b2-subproblem, then
		// maximize b4-subproblem due to double negation. This insight will help reduce
		// the complexity a lot since we only need one DP instead of two.
		memo[left][right] = Math.max(curScoreRemoveLeft - helper(left + 1, right, memo),
				curScoreRemoveRight - helper(left, right - 1, memo));

		return memo[left][right];
	}
}
