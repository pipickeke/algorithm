package com.pipickeke.algrithm.code2024.month12.week4;

public class Longest_Nice_Subarray {


    private int longestNiceSubarray(int[] nums){

        int ans = 0;
        for (int i = 0, or = 0; i < nums.length; i++) {

            int j = i;
            while ( j >= 0 && (or & nums[j]) == 0){
                or |= nums[j];
                j--;
            }
            ans = Math.max(ans, i-j);
        }
        return ans;
    }

    private int longestNiceSubarray2(int[] nums){

        int ans = 0;
        for (int right = 0, left = 0, or = 0; right < nums.length; right++) {
            while ( (or & nums[right]) > 0 ){
                or ^= nums[left++];
            }
            or |= nums[right];
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
