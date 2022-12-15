package binarySearch;

import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval {
//436
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int[] findRightInterval(int[][] intervals) {
		    
	        if(intervals.length==1){
	            return new int[]{-1};
	        }
	        HashMap<Integer,Integer> map=new HashMap();
	        int i=0;
	        for(int interval[]:intervals){
	            map.put(interval[0],i++);
	        }
	        
	        int ans[]=new int[intervals.length];
	        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
	        //increasing based on interval[0]--> unique val
	        for( i=0;i<intervals.length;i++){
	            int idx=map.get(intervals[i][0]);
	            int []ansidx=bs(intervals,intervals[i][1]);
	            if(ansidx!=null){
	                ans[idx]=map.get(ansidx[0]);
	            }else{
	                ans[idx]=-1;
	            }
	            
	        }
	        
	        return ans;
	        
	        
	    }
	    
	    int[] bs(int[][] intervals,int target){
	        
	        int lo=0;
	        int hi=intervals.length-1;
	        int []ans=null;
	        while(lo<=hi){
	            int mid=lo+(hi-lo)/2;
	            if(intervals[mid][0]>=target){
	                hi=mid-1;
	                ans=intervals[mid];
	            }else{
	                lo=mid+1;
	            }
	        }
	        return ans;
	    }

}
