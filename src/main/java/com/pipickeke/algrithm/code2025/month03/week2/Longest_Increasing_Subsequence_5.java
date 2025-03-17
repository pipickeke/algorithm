package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 300. 最长递增子序列
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */

public class Longest_Increasing_Subsequence_5 {


    private int lengthOfLIS(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : nums) {
            int y = lowbound(list, x);
            if (y == list.size()){
                list.add(x);
            } else {
                list.set(y, x);
            }
        }
        return list.size();
    }

    private int lowbound(List<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;
        while (left < right){
            int mid = (left+right) >>> 1;
            if (list.get(mid) < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
