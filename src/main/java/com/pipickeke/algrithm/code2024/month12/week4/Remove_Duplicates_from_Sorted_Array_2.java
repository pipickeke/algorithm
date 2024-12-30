package com.pipickeke.algrithm.code2024.month12.week4;

public class Remove_Duplicates_from_Sorted_Array_2 {

    private int removeDuplicates(int[] nums){

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
