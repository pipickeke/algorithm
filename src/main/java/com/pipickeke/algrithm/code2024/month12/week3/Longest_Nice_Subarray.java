package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：2401. 最长优雅子数组
 * 标签：暴力枚举、滑动窗口
 *
 * 给你一个由 正 整数组成的数组 nums 。
 *
 * 如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，
 * 则称该子数组为 优雅 子数组。
 *
 * 返回 最长 的优雅子数组的长度。
 *
 * 子数组 是数组中的一个 连续 部分。
 *
 * 注意：长度为 1 的子数组始终视作优雅子数组。
 *
 *
 */
public class Longest_Nice_Subarray {

    /**
     * 暴力枚举
     *
     * 从nums[0]开始，依次枚举
     * 查看每次以 nums[i] 结尾的子数组中，是否任意两个数是 & 是0（ or & num[j] == 0）
     * 为了加速， or |= num[j], j--, 通过 |= 记录访问过的数字，供下次判断可用
     *
     * @param nums
     * @return
     */
    private int longestNiceSubarray(int[] nums){
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            int or = 0;
            int j = i;
            while (j >= 0 && ( (or & nums[j]) == 0)){
                or |= nums[j--];
                ans = Math.max(ans, i-j);
            }
        }
        return ans;
    }


    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    private int longestNiceSubarray_2(int[] nums){

        int ans = 0;
        for (int right = 0, left = 0, or = 0; right < nums.length; right++) {

            while (( or & nums[right]) > 0){
                or ^= nums[left++]; //不断抹掉窗口的左侧
            }
            or |= nums[right];
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
