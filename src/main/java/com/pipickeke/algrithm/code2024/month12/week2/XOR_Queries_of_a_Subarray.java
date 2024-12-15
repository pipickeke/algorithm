package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.Arrays;


/**
 * 题目：子数组异或查询
 *
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值
 * （即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 */
public class XOR_Queries_of_a_Subarray {

    public static void main(String[] args) {
        XOR_Queries_of_a_Subarray bean = new XOR_Queries_of_a_Subarray();
        int[] arr = {1,3,4,8};
        int[][] matrix = {{0,1}, {1,2}, {0,3}, {3,3}};
        System.out.println(Arrays.toString(bean.xorQueries(arr, matrix)));
    }

    private int[] xorQueries(int[] arr, int[][] queries){

        int[] xor = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            xor[i+1] = xor[i] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = xor[queries[i][0]] ^ xor[queries[i][1]+1];
        }
        return ans;
    }
}
