package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.HashMap;
import java.util.Map;


/**
 * 题目：70. 爬楼梯
 * 标签：动态规划
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */

public class Climbing_Stairs {

    private int climbStairs(int n){
        map = new HashMap<>();
        return dfs(n);
    }

    private int dfs(int n){
        if (n < 2){
            return 1;
        } else {
            if (map.containsKey(n-1) && map.containsKey(n-2)){
                return map.get(n-1) + map.get(n-2);
            } else {
                int ans = dfs(n-1) + dfs(n-2);
                map.put(n, ans);
                return ans;
            }
        }
    }

    private Map<Integer,Integer> map;

    /**
     * 递推
     * @param n
     * @return
     */
    private int climbStairs2(int n){
        int[] f = new int[n+1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }


    /**
     * 空间优化
     * @param n
     * @return
     */
    private int climbStairs3(int n){
        int p = 1;
        int q = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = p + q;
            p = q;
            q = tmp;
        }
        return q;
    }



}
