package binarySearch;

public class MaxMinPoweredCity {
//2528
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int len;
    public long maxPower(int[] stations, int r, int k) {
		this.len = stations.length;

		long pre[] = new long[len + 1];
		long pow[] = new long[len + 1];
		for (int i = 1; i <= len; i++) {
			pre[i] += pre[i - 1] + stations[i - 1];
		}

		for (int i = 1; i <= len; i++) {
			int ub = Math.min(len, i + r);
			int lb = Math.max(0, i - r - 1);
			pow[i] = pre[ub] - pre[lb];
		}

		long lo = 0;
		long hi = pre[len] + k;
		long ans = 0;
		while (lo <= hi) {
			long mid= lo + (hi - lo) / 2;

			if (check(mid, r, k, pow)) {	//binary Search
				ans = mid;
				lo = mid + 1;

			} else {
				hi = mid-1;
			}
		}
		return ans;
	}
    
    boolean check(long target,int r,int available,long[] power){
        long diff[]=new long[len+1];
        long powerDiff=0L;
       
        
        for(int i=1;i<=len;i++){	//sliding window
            powerDiff+=diff[i-1];
            long needed=target-power[i]-powerDiff;
            if(needed>0){
                available-=needed;
                if(available<0){
                    return false;
                }
                diff[i]+=needed;
                if(i+2*r<=len){
                    diff[i+2*r]-=needed;
                }
            }
        }
        return true;
    }
}
