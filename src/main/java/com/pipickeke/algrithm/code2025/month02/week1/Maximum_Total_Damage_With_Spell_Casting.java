package com.pipickeke.algrithm.code2025.month02.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maximum_Total_Damage_With_Spell_Casting {


    private long maximumTotalDamage(int[] power){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : power) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int n = map.size();
        int[] arr = new int[n];
        int index = 0;
        for (Integer key : map.keySet()) {
            arr[index++] = key;
        }

        Arrays.sort(arr);
        long[] memo = new long[n];
        Arrays.fill(memo,-1);
        return dfs(n-1, arr, memo, map);
    }

    private long dfs(int index, int[] nums, long[] memo, Map<Integer,Integer> map){

        if (index < 0){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }

        int x = nums[index];
        int j = index;
        while (j >= 0 && nums[j-1] >= (x-2)){
            j--;
        }
        return memo[index] = Math.max(dfs(index-1, nums, memo, map),
                dfs(j-1, nums, memo, map) + (long) x * map.getOrDefault(x,0));
    }
}
