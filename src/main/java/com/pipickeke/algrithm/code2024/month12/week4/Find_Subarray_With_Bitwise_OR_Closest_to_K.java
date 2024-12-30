package com.pipickeke.algrithm.code2024.month12.week4;

public class Find_Subarray_With_Bitwise_OR_Closest_to_K {

    /**
     * 暴力
     * @param nums
     * @param k
     * @return
     */
    private int minimumDifference(int[] nums, int k){

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x-k));

            for (int j = i-1; j >= 0; j--) {
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }

    private int minimumDifference_2(int[] nums, int k){
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x-k));
            for (int j = i-1; j >= 0 && (x | nums[j]) != nums[j] ; j--) {
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}
