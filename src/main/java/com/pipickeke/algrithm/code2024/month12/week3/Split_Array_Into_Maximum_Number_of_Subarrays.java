package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：2871. 将数组分割成最多数目的子数组
 *
 * 给你一个只包含 非负 整数的数组 nums 。
 *
 * 我们定义满足 l <= r 的子数组 nums[l..r] 的分数为
 * nums[l] AND nums[l + 1] AND ... AND nums[r] ，其中 AND 是按位与运算。
 *
 * 请你将数组分割成一个或者更多子数组，满足：
 *
 * 每个 元素都 只 属于一个子数组。
 * 子数组分数之和尽可能 小 。
 * 请你在满足以上要求的条件下，返回 最多 可以得到多少个子数组。
 *
 * 一个 子数组 是一个数组中一段连续的元素。
 *
 *  思路：
 *      （1） 与运算，参与的数越多，结果越小
 *      （2） 如果数组 nums[] 整体的 与运算 结果a， a > 0,
 *              那么数组的任意子数组的与运算，结果之和肯定 大于a ，不满足最小条件，
 *               此时不能分割，只能是1
 *      （3） 如果数组 nums[] 整体 与运算 结果a， a==0
 *             则分割出的每个子数组 与运算 需要要是0，遇到是0的，就立即分割
 *              如果不立即分割，后面的子数组就少了，他们的与运算结果肯定变大
 *              如果最后一段子数组的 与运算 结果 >0, 则可以将这段子数组与倒数第二段子数组合并
 *
 */
public class Split_Array_Into_Maximum_Number_of_Subarrays {

    private int maxSubarrays(int[] nums){

        int ans = 0;
        int mask = -1; //作掩码，实际的 111....111
        for (int i = 0; i < nums.length; i++) {
            mask &= nums[i];
            if (mask == 0){
                ans ++;
                mask = -1;
            }
        }
        return Math.max(ans, 1);
    }
}
