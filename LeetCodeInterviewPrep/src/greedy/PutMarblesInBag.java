package greedy;

import java.util.Arrays;

public class PutMarblesInBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PutMarblesInBag obj=new PutMarblesInBag();
		int []weights = {1,3,5,1};
		int k = 2;
		System.out.println(obj.putMarbles(weights, k));
	}

	
	public long putMarbles(int[] weights, int k) {
        int len=weights.length;
        int splitPointsPairs[]=new int[len-1];
        
        for(int i=0;i<len-1;i++){
            splitPointsPairs[i]=weights[i]+weights[i+1];
        }
        
        Arrays.sort(splitPointsPairs);
        long ans=0;
        for(int i=0;i<k-1;i++){
          ans+= splitPointsPairs[len-2-i]-splitPointsPairs[i]  ;  
        }
        
        return ans;
    }
}
