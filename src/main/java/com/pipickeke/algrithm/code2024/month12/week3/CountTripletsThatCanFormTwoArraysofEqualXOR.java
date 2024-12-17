package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：形成两个异或相等数组的三元组数目
 *
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 */
public class CountTripletsThatCanFormTwoArraysofEqualXOR {

    private int countTriplets(int[] arr){
        int[] record = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            record[i+1] = arr[i] ^ record[i];
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (record[i] == record[k+1]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
