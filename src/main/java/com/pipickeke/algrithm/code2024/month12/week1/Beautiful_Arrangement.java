package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.ArrayList;
import java.util.List;


/**
 *  题目：优美的排列
 *  假设有从 1 到 n 的 n 个整数。
 *  用这些整数构造一个数组 perm（下标从 1 开始），
 *  只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
 *
 *  perm[i] 能够被 i 整除
 *  i 能够被 perm[i] 整除
 *  给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
 *
 *  思路：回溯
 *      [1,n]
 *      满足条件的，其实就是：
 *      perm[i] % i == 0
 *      i % perm[i] == 0
 *      等同与  双层遍历i，j  [1,n]
 *      满足： i%j == 0 || j%i ==0
 *
 *      用二维数组，保存可能存在的情况 ： list[i].add[j]
 *      然后开始深度遍历，dfs(index,n)  首先从 dfs(1,n)
 *      如果遍历到的数字已经存在 vis[x] ==true，则跳过，否则遍历，并记录访问状态
 */
public class Beautiful_Arrangement {

    public static void main(String[] args) {

    }

    private List<Integer>[] match;
    private int nums;
    private boolean[] vis;
    private int countArrangement(int n){

        match = new List[n+1];
        vis = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i % j == 0) || (j % i == 0)){
                    match[i].add(j);
                }
            }
        }

        dfs(1, n);
        return nums;
    }

    private void dfs(int index, int n){
        if (index == n + 1){
            nums++;
            return;
        }

        for (Integer x : match[index]) {
            if (!vis[x]){
                vis[x] = true;
                dfs(index+1, n);
                vis[x] = false;
            }
        }
    }
}








