package segmentTree;

public class RangeSumQueryMutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ["NumArray","sumRange","sumRange","sumRange","update","update","update",
		 * "sumRange","update","sumRange","update"]
		 * [[[]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
		 */

		int nums[]= {0,9,5,7,3};				
		RangeSumQueryMutable obj=new RangeSumQueryMutable(nums);
		System.out.println(obj.sumRange(4, 4));
		System.out.println(obj.sumRange(2, 4));
		System.out.println(obj.sumRange(3, 3));
		obj.update(4, 5);
		obj.update(1, 7);
		obj.update(0, 8);
		System.out.println(obj.sumRange(1, 2));
		obj.update(1, 9);
		System.out.println(obj.sumRange(4, 4));
		obj.update(3, 4);
		
	}
	
	
	 int tree[];
	    int nums[];
	    public RangeSumQueryMutable(int[] nums) {
	        this.nums=nums;
	    tree=new int[4*nums.length];
	        
	        buildTree(nums,0,nums.length-1,0);
	    }
	    
	    int buildTree(int[] nums,int lo,int hi,int pos){
	        
	        if(hi==lo){
	            tree[pos]=nums[lo];
	            return nums[lo];
	        }
	        int mid= (lo+hi)/2;
	        return tree[pos]= buildTree(nums,lo,mid,2*pos+1) +
	                            buildTree(nums,mid+1,hi,2*pos+2);
	    }
	    
	    public void update(int index, int val) {
	        update(index,0,0,nums.length-1,val);
	    }
	    
	    void update(int index,int curIdx,int lo,int hi,int val){
	        
	        if(lo==hi){
	            tree[curIdx]=val;
	        }else{
	            int mid=(lo+hi)/2;
	            if(index<=mid){
	                update(index,2*curIdx+1,lo,mid,val);
	            }else{
	                update(index,2*curIdx+2,mid+1,hi,val);
	            }
	            tree[curIdx]=tree[curIdx*2+1]+ tree[curIdx*2+2];
	        }
	    }
	    
	    
	    
	    public int sumRange(int left, int right) {
	        return getSumRange(left,right,0,0,nums.length-1);
	    }
	    
	  int  getSumRange(int left,int right,int curIdx,int lo,int hi){
	      
	      if(lo==left && hi==right){
	          return tree[curIdx];
	      }else{
	          int mid=(lo+hi)/2;
	          if(right<=mid){
	              return getSumRange(left,right,2*curIdx+1,lo,mid);
	          }else if(left>mid){
	              return getSumRange(left,right,2*curIdx+2,mid+1,hi);
	          }else{
	              return getSumRange(left,mid,2*curIdx+1,lo,mid) + getSumRange(mid+1,right,2*curIdx+2,mid+1,hi);
	          }
	      }
	  }

}
