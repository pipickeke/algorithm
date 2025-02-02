package com.pipickeke.algrithm.code2025.month01.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


/**
 * 题目：3186. 施咒的最大总伤害
 *
 * 一个魔法师有许多不同的咒语。
 *
 * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
 *
 * 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，
 * power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
 *
 * 每个咒语最多只能被使用 一次 。
 *
 * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
 *
 */


public class Maximum_Total_Damage_With_Spell_Casting {

    public static void main(String[] args) {
        Maximum_Total_Damage_With_Spell_Casting bean = new Maximum_Total_Damage_With_Spell_Casting();
        int[] power = {31,76,37,35,25,18,59,57,75,82,69,41,9,53,24,54,54,17,45,46,45,27,39,17,29,56,37,57,29,32,28,74};
        System.out.println(bean.maximumTotalDamage(power));
    }

    private long maximumTotalDamage(int[] power){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : power) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int n = map.size();
        int[] arr = new int[n];
        int i = 0;
        for (Integer x : map.keySet()) {
            arr[i++] = x;
        }

        Arrays.sort(arr);

        long[] memo = new long[n];
        Arrays.fill(memo,-1);
        return dfs(n-1, arr, memo, map);
    }

    private long dfs(int index, int[] arr, long[] memo, Map<Integer,Integer> map){
        if (index < 0){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }

        int x = arr[index];
        int j = index;
        while (j > 0 && arr[j-1] >= (x-2)){
            j--;
        }
        return memo[index] = Math.max(dfs(index-1, arr,memo,map),
                dfs(j-1,arr,memo,map) + (long) x * map.get(x));
    }


    /**
     * 递推
     * @param power
     * @return
     */
    private long maximumTotalDamage_2(int[] power){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : power) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int n = map.size();
        int[] arr = new int[n];
        int i = 0;
        for (Integer key : map.keySet()) {
            arr[i++] = key;
        }

        Arrays.sort(arr);

        long[] dp = new long[n+1];
        int j = 0;
        for (int k = 0; k < n; k++) {
            int x = arr[k];
            while (arr[j] < x-2){
                j++;
            }
            dp[k+1] = Math.max(dp[k], dp[j] + x * map.getOrDefault(x,0));
        }
        return dp[n];
    }
}








