package com.pipickeke.algrithm.code2025.month02.week4;

/**
 * 题目：918. 环形子数组的最大和
 *
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是
 * nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i],
 * nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 */

public class Maximum_Sum_Circular_Subarray {

    private int maxSubarraySumCircular(int[] nums){
        int maxS = Integer.MIN_VALUE;
        int minS = 0;
        int fmax = 0, fmin = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            fmax = Math.max(fmax, 0) + nums[i];
            maxS = Math.max(maxS, fmax);

            fmin = Math.min(fmin, 0) + nums[i];
            minS = Math.min(minS, fmin);

            sum += nums[i];
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);
    }
}
