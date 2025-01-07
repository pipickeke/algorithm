package com.pipickeke.algrithm.code2025.month01.week1;


/**
 * 题目：1512. 好数对的数目
 * 标签：枚举右维护左
 *
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 *
 */

public class Number_of_Good_Pairs {


    private int numIdenticalPairs(int[] nums){
        int ans = 0;
        int[] cnt = new int[101];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans += cnt[x];
            cnt[x]++;
        }
        return ans;
    }
}
