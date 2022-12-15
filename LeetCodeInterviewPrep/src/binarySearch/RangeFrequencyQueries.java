package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFrequencyQueries {


//2080
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {12,33,4,56,22,2,34,33,22,12,34,56};
		
		RangeFrequencyQueries obj=new RangeFrequencyQueries(nums);
		System.out.println(obj.query(1, 2, 4));
		System.out.println(obj.query(0, 11, 33));

	}
Map<Integer, List<Integer>> map = new HashMap();
    
    public RangeFrequencyQueries(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        List<Integer> A = map.get(value);
        if(A == null || left > A.get(A.size()-1) || right < A.get(0))
            return 0;
        
        int i = ceil(A, left), j = floor(A, right);        
        return j-i+1;
    }
    
    public int ceil(List<Integer> A, int x){
        int left = 0, right = A.size()-1; 
        if(x < A.get(0))
            return 0;
        
        while(left < right){
            int mid = (left+right)/2;
            if(A.get(mid) < x)
                left = mid + 1;
            else 
                right = mid;
        }
        return left;
    }
    
    public int floor(List<Integer> A, int x){
        int left = 0, right = A.size()-1; 
        if(x > A.get(right))
            return right;
        
        while(left < right){
            int mid = (left+right)/2+1;
            if(A.get(mid) > x)
                right = mid - 1;
            else 
                left = mid;
        }
        return left;
    }    
	
}
