package dynamicProgramming;

import java.util.HashSet;

public class NoGoodWaysToSplitString {

	//1525
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NoGoodWaysToSplitString obj = new NoGoodWaysToSplitString();
		String s = "aaaaa";
		System.out.println(obj.numSplits(s));
	}

	public int numSplits(String s) {
		int len = s.length();
		int pre[] = new int[len];
		HashSet<Character> set = new HashSet();
		HashSet<Character> suff = new HashSet();
		int suf[] = new int[len];
		pre[0] = 1;
		set.add(s.charAt(0));
		for (int i = 1; i < len; i++) {
			if (set.add(s.charAt(i))) {

				pre[i] = pre[i - 1] + 1;
			} else {
				pre[i] = pre[i - 1];
			}

		}

		suf[len - 1] = 1;
		suff.add(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; i--) {
			if (suff.add(s.charAt(i))) {

				suf[i] = suf[i + 1] + 1;
			} else {
				suf[i] = suf[i + 1];
			}
		}
		int res = 0;
		for (int i = 0; i < len-1; i++) {
			if (pre[i] == suf[i + 1]) {
				res++;
			}
		}

		return res;
	}
}
