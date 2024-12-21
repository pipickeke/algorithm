package com.pipickeke.algrithm.code2024.month12.week3;

import java.util.HashMap;
import java.util.Map;


/**
 * 题目：2588. 统计美丽子数组数目
 *
 * 给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
 *
 * 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。
 * 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的
 * 第 k 位（下标编号从 0 开始）是 1 。
 * 将 nums[i] 和 nums[j] 都减去 2k 。
 * 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，
 * 那么我们称它是一个 美丽 的子数组。
 *
 * 请你返回数组 nums 中 美丽子数组 的数目。
 *
 * 子数组是一个数组中一段连续 非空 的元素序列。
 *
 *  思路：利用异或前缀和
 *      xorsum(i+1) = num(0) ^ num(1) ^...^num(i)
 *      xorsum(j) = num(0) ^ num(1) ^...^num(j-1)
 *      子数组[j,i]的异或和
 *      xorsum(j,i) = num(j) ^ num(j+1) ^...^num(i)
 *              => xorsum(i+1) ^ xorsum(j)
 *      而如果要子数组 xorsum(j,i) ==0，
 *              则 xorsum(i+1) == xorsum(j)
 *       则求解的核心就是计算异或前缀和中 xorsum 中，有多少相同的前缀和，则其对应的子数组就转换为全0
 *
 */
public class Count_the_Number_of_Beautiful_Subarrays {

    private long beautifulSubarrays(int[] nums){
        int[] xorarr = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            xorarr[i+1] = xorarr[i] ^ nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < xorarr.length; i++) {
            ans += map.getOrDefault(xorarr[i],0);
            map.merge(xorarr[i], 1, Integer::sum);
        }
        return ans;
    }
}
