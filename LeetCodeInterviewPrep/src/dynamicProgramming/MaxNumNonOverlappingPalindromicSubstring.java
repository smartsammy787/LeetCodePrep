package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//2472

// O(n^2) sol. there is also greedy sol for O(n*k) check later
public class MaxNumNonOverlappingPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxNumNonOverlappingPalindromicSubstring obj = new MaxNumNonOverlappingPalindromicSubstring();
		String s = "abaccdbbd";
		int k = 3;
		System.out.println(obj.maxPalindromes(s, k));
	}

	public int maxPalindromes(String s, int k) {

		if (k == 1)
			return s.length();

		int len = s.length();
		int ans = 0;
		int last = Integer.MIN_VALUE;
		List<List<Integer>> intervals = new ArrayList<List<Integer>>();

		int dp[][] = new int[len][len];

		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}

		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {

				if (s.charAt(i) == s.charAt(j)) {
					if (j - i == 1 || dp[i + 1][j - 1] == 1) {
						dp[i][j] = 1;
						if (j - i + 1 >= k) {
							intervals.add(new ArrayList<Integer>(Arrays.asList(i, j + 1)));
						}
					}
				}

			}

		}

		Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));// increasing on start index
		for (List<Integer> li : intervals) {
			if (li.get(0) >= last) {
				last = li.get(1);
				ans++;
			} else {
				if (li.get(1) < last) {
					last = li.get(1);
				}
			}
		}
		return ans;
	}

}
