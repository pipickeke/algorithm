package com.pipickeke.algrithm.code2024.month12.week4;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 题目：898. 子数组按位或操作
 * 标签：Logtrick、子数组、
 *
 * 给定一个整数数组 arr，返回所有 arr 的非空子数组的不同按位或的数量。
 *
 * 子数组的按位或是子数组中每个整数的按位或。含有一个整数的子数组的按位或就是该整数。
 *
 * 子数组 是数组内连续的非空元素序列。
 *
 *
 */


public class Bitwise_ORs_of_Subarrays {

    private int subarrayBitwiseORs(int[] arr){

        int N = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int x = arr[i];
            set.add(x);

            for (int j = i-1; j >= 0 && (arr[j] | x) != arr[j]; j--) {
                arr[j] |= x;
                set.add(arr[j]);
            }
        }
        return set.size();
    }
}
