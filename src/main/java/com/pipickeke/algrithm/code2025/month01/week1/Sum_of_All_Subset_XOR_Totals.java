package com.pipickeke.algrithm.code2025.month01.week1;


/**
 * 题目：1863. 找出所有子集的异或总和再求和
 * 标签：子集、递归
 *
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 *
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 *
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 *
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 *
 */

public class Sum_of_All_Subset_XOR_Totals {

    public static void main(String[] args) {
        Sum_of_All_Subset_XOR_Totals bean = new Sum_of_All_Subset_XOR_Totals();
        int[] nums = {5,1,6};
        System.out.println(bean.subsetXORSum(nums));
    }

    private int subsetXORSum(int[] nums){
        res = 0;
        dfs(0,0,nums);
        return res;
    }

    private int res = 0;
    private void dfs(int index, int xorsum, int[] nums){
        if (index == nums.length){
            res += xorsum;
            return;
        }
        dfs(index+1, xorsum, nums);
        dfs(index+1, xorsum ^ nums[index], nums);
    }
}

/**
 *     num[0]
 *     num[0]^num[1] num[1]
 *     num[0]^num[1]^num[2] num[1]^num[2] num[2]
 *
 *     5
 *     5^1 1
 *     5^1^6 1^6 6
 *
 *
 */
