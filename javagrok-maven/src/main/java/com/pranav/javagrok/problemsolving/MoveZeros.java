package com.pranav.javagrok.problemsolving;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 * @author pbhatt
 *
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i=0;
        int nonZeroPos = 0;
        while(i < nums.length){
            if(nums[i] != 0){
                nums[nonZeroPos++] = nums[i];
            }
            i++;
        }
        while(nonZeroPos < nums.length){
            nums[nonZeroPos] = 0;
            nonZeroPos++;
        }
    }
}
