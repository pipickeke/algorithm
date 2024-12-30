package com.pipickeke.algrithm.code2024.month12.week4;

public class Find_Subarray_With_Bitwise_OR_Closest_to_K_2 {

    private int minimumDifference(int[] nums, int k){

        int N = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {

            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k));
            for (int j = i-1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}
