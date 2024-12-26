package com.pipickeke.algrithm.code2024.month12.week4;

import java.util.Arrays;
import java.util.Map;

/**
 * 题目：3117. 划分数组得到最小的值之和
 *
 * 给你两个数组 nums 和 andValues，长度分别为 n 和 m。
 *
 * 数组的 值 等于该数组的 最后一个 元素。
 *
 * 你需要将 nums 划分为 m 个 不相交的连续
 * 子数组
 * ，对于第 ith 个子数组 [li, ri]，子数组元素的按位 AND 运算结果等于 andValues[i]，换句话说，对所有的 1 <= i <= m，nums[li] & nums[li + 1] & ... & nums[ri] == andValues[i] ，其中 & 表示按位 AND 运算符。
 *
 * 返回将 nums 划分为 m 个子数组所能得到的可能的 最小 子数组 值 之和。如果无法完成这样的划分，则返回 -1
 *
 */

public class Minimum_Sum_of_Values_by_Dividing_Array {

    public static void main(String[] args) {
        Minimum_Sum_of_Values_by_Dividing_Array bean = new Minimum_Sum_of_Values_by_Dividing_Array();
        int[] nums = {1,4,3,3,2};
        int[] andValues = {0,3,3,2};
        bean.minimumValueSum(nums, andValues);
    }

    private int minimumValueSum(int[] nums, int[] andValues){
        int res = dfs(0,0, -1, nums, andValues);
        return res < Integer.MAX_VALUE/2 ? res : -1;
    }

    private int dfs(int i, int j, int and, int[] nums, int[] andValues){
        int n = nums.length;
        int m = andValues.length;
        if (n-i < m-j){
            return Integer.MAX_VALUE/2;
        }
        if (j == m){
            return i == n ? 0 : Integer.MAX_VALUE/2;
        }

        and &= nums[i];
        int res = dfs(i+1, j, and, nums, andValues);

        if (and == andValues[j]){
            res = Math.min(res, dfs(i+1, j+1, and, nums, andValues) + nums[i]);
        }
        return res;
    }
}
