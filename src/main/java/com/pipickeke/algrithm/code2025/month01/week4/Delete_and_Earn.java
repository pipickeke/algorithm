package com.pipickeke.algrithm.code2025.month01.week4;

import java.util.*;
import java.util.stream.Stream;

/**
 * 题目：740. 删除并获得点数
 *
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 */

public class Delete_and_Earn {

    public static void main(String[] args) {
        Delete_and_Earn bean = new Delete_and_Earn();
        int[] nums = {3,4,2};
        System.out.println(bean.deleteAndEarn(nums));
    }

    private int deleteAndEarn(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int x : nums) {
            treeSet.add(x);
        }

        int n = treeSet.last();

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = map.getOrDefault(1,0)*1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + map.getOrDefault(i,0) * i );
        }

        return dp[n];
    }




}








