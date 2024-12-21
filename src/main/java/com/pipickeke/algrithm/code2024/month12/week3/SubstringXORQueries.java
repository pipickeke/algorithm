package com.pipickeke.algrithm.code2024.month12.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：2564. 子字符串异或查询
 *
 * 给你一个 二进制字符串 s 和一个整数数组 queries ，其中 queries[i] = [firsti, secondi] 。
 *
 * 对于第 i 个查询，找到 s 的 最短子字符串 ，它对应的 十进制值 val 与 firsti 按位异或 得到 secondi ，
 * 换言之，val ^ firsti == secondi 。
 *
 * 第 i 个查询的答案是子字符串 [lefti, righti] 的两个端点（下标从 0 开始），如果不存在这样的子字符串，
 * 则答案为 [-1, -1] 。如果有多个答案，请你选择 lefti 最小的一个。
 *
 * 请你返回一个数组 ans ，其中 ans[i] = [lefti, righti] 是第 i 个查询的答案。
 *
 * 子字符串 是一个字符串中一段连续非空的字符序列。
 *
 *  思路：
 *
 */

public class SubstringXORQueries {

    public static void main(String[] args) {
        SubstringXORQueries bean = new SubstringXORQueries();
        String s = "101101";
        int[][] queries = {{0,5},{1,2}};
        System.out.println(Arrays.deepToString(bean.substringXorQueries2(s, queries)));
    }

    private int[][] substringXorQueries(String s, int[][] queries){

        HashMap<Integer, int[]> map = new HashMap<>();
        int zero = s.indexOf('0');
        if (zero >= 0){
            map.put(0, new int[]{zero, zero});
        }

        char[] strs = s.toCharArray();
        for (int l = 0; l < strs.length; l++) {

            if (strs[l] == '0') continue;

            for (int r = l, x=0; r < Math.min(l + 30, strs.length); r++) {
                x = (x << 1) | (strs[r] & 1);
                map.putIfAbsent(x, new int[]{l, r});
            }
        }

        int[][] ans = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1,-1});
        }
        return ans;
    }



    private int[][] substringXorQueries2(String s, int[][] queries){
        HashMap<Integer, int[]> map = new HashMap<>();

        int zero = s.indexOf('0');
        if (zero >= 0){
            map.put(0, new int[]{zero,zero});
        }

        char[] strs = s.toCharArray();
        int[][] ans = new int[queries.length][];
        for (int l = 0; l < strs.length; l++) {

            if (strs[l] == '0') continue;

            for (int r = l, x = 0; r < Math.min(l + 30, strs.length); r++) {
                x = (x << 1) | (strs[r] & 1);
                map.putIfAbsent(x, new int[]{l, r});
            }
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1,-1});
        }
        return ans;
    }


}
