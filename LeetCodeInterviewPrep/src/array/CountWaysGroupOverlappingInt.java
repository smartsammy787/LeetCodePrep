package array;

import java.util.Arrays;

public class CountWaysGroupOverlappingInt {

	int mod = 1_000_000_007;

	public int countWays(int[][] ranges) {

		long c = 2;
		int len = ranges.length;
		Arrays.sort(ranges, (a, b) -> a[0] - b[0]);

		// for(int i=0;i<ranges)
		int x = 1;
		int curlow = ranges[0][0];
		int curhigh = ranges[0][1];
		while (x < len) {
			if (ranges[x][0] > curhigh) {
				// non overlap
				curlow = ranges[x][0];
				curhigh = ranges[x][1];
				c = (c * 2) % mod;
			} else {
				// pverlapping

				if (curhigh < ranges[x][1]) {
					curhigh = ranges[x][1];
				}

			}
			x++;
		}

		return (int) (c);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] ranges = {{1,3},{10,20},{2,5},{4,8}};
		CountWaysGroupOverlappingInt obj = new CountWaysGroupOverlappingInt();
		System.out.println(obj.countWays(ranges));
	}

}
