package com.pranav.javagrok.algorithms;

/**
 * 
 * @author pbhatt
 *
 */
public class BinarySearch {
	// return index of the key if present, else return -1
	public int search(int[] array, int val) {
		int result = -1;
		if(array == null || array.length == 0) return result;
		int st = 0;
		int en = array.length-1;
		while(st <= en) {
			int mid = st + (en-st)/2;
			if(array[mid] == val) {
				result = mid;
				break;
			}else if(array[mid] < val) {
				st = mid+1;
			}else {
				en = mid-1;
			}
		}
		return result;
	}
	
	/**
	 * https://leetcode.com/problems/sqrtx/description/
	 */
	 public int mySqrt(int x) {
			int lo = 1, hi = x, res = 0;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (mid <= x/mid) {
					res = mid;
					lo = mid + 1;
				} else{
					hi = mid - 1;
	            }
			}
			return res;
	    }
	
	/**
	 * https://leetcode.com/problems/find-peak-element/description/
	 * @return
	 */
	public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[mid+1]){
                //peak element will be in the right side
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
