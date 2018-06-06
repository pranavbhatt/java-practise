package com.pranav.javagrok.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element/description/
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * @author pbhatt
 *
 */
public class MooreVotingAlgorithm {
    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = 0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                maj = nums[i];
                count++;
                continue;
            }
            
            if(nums[i] == maj){
                count++;
            }else{
                count--;
            }
        }
        
        return maj;
    }
    
    /**
     * elements that appear more than ⌊ n/3 ⌋ times
     * can be max: 2
     */
    public List<Integer> majorityElementExt(int[] nums) {
        int count1 = 0;
        int maj1 = 0;
        int count2 = 0;
        int maj2 = 0;
        for(int i=0;i<nums.length;i++){
             if(nums[i] == maj1){
                count1++;
            }else if(nums[i] == maj2){
                count2++;
            }else if(count1 == 0){
                maj1 = nums[i];
                count1++;
            }else if(count2 == 0){
                maj2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        
        for(int i:nums){
            if(i==maj1){
                count1++;
            }
            else if(i==maj2){
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        if(count1 > nums.length/3){
            result.add(maj1);
        }
        
        if(count2 > nums.length/3){
            result.add(maj2);
        }
        
        
        return result;
    }
}
