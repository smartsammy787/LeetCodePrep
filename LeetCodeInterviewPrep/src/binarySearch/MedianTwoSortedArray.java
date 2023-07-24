package binarySearch;

public class MedianTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MedianTwoSortedArray obj = new MedianTwoSortedArray();
		int nums1[] = { 1, 3 };
		int nums2[] = { 2 };

		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		int totalLen = nums1.length + nums2.length;

		int halfLen = totalLen / 2;
		int lo = 0;
		int hi = nums1.length - 1;
		int aidx;
		while (true) {
			
			
		
			 aidx = Math.floorDiv(lo+hi, 2); //(lo + hi) / 2;
			
			int bidx = halfLen - (aidx+1) - 1;

			int nums1Left = aidx >= 0 ? nums1[aidx] : Integer.MIN_VALUE;
			int nums1Right = aidx + 1 < nums1.length ? nums1[aidx + 1] : Integer.MAX_VALUE;
			int nums2Left = bidx >= 0 ? nums2[bidx] : Integer.MIN_VALUE;
			int nums2Right = bidx + 1 < nums2.length ? nums2[bidx + 1] : Integer.MAX_VALUE;

			if (nums1Left <= nums2Right && nums1Right >= nums2Left) {
				if (totalLen % 2 == 1) {
					return Math.min(nums1Right, nums2Right); // odd length
				} else {
					// even length
					return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / (double) 2;
				}
			} else if (nums1Left > nums2Right) {
				hi = aidx - 1;
			} else {
				lo = aidx + 1;
			}

		}
	

	}

}
