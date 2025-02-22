package com.pipickeke.algrithm.code2025.month02.week3;

public class Maximum_Absolute_Sum_of_Any_Subarray_2 {

    private int maxAbsoluteSum(int[] nums){
        int fmax=0, fmin=0;
        int N = nums.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            fmax = Math.max(fmax,0) + nums[i];
            fmin = Math.min(fmin,0) + nums[i];
            ans = Math.max(ans, Math.max(fmax, -fmin));
        }
        return ans;
    }
}
