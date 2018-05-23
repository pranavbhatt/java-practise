package com.pranav.javagrok.problemsolving;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * @author pbhatt
 *
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(2, Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        
        while(k > 1){
            pq.poll();
            k--;
        }
        return (int) pq.poll();
    }
}
