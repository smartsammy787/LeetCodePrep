package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestIncreasingSubsequence obj=new LongestIncreasingSubsequence();
	int nums[]=	{10,9,2,5,3,7,101,18};

		System.out.println(obj.lengthOfLIS(nums));
	}
	
public int lengthOfLIS(int[] nums) {
        
        List<Integer> list=new ArrayList();
        
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int index=binarySearch(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        return list.size();
    }
    
    
    int binarySearch(List<Integer> list,int target){
        int lo=0;
        int hi=list.size()-1;
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(list.get(mid)<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;
    }

}
