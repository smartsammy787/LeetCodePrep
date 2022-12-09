package dynamicProgramming;

public class CountPalindromicSubstrings {
///647
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="aaa";
		
		CountPalindromicSubstrings obj=new CountPalindromicSubstrings();
		System.out.println(obj.countSubstrings(s));
	}

	public int countSubstrings(String s) {

		int len = s.length();
		int ans = len;
		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}

		for (int startidx = len - 1; startidx >= 0; startidx--) {

			for (int endidx = startidx + 1; endidx < len; endidx++) {

				if (s.charAt(startidx) == s.charAt(endidx)) {
					if (endidx - startidx == 1 || dp[startidx + 1][endidx - 1] == 1) {
						dp[startidx][endidx] = 1;
						ans++;
					}
				}

			}

		}
		return ans;
	}

}
