package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：1857. 有向图中最大颜色值
 * 标签：拓扑排序、广度优先遍历
 *
 * 给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。
 *
 * 给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的
 * 颜色 （下标从 0 开始）。同时给你一个二维数组 edges ，其中 edges[j] = [aj, bj]
 * 表示从节点 aj 到节点 bj 有一条 有向边 。
 *
 * 图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，
 * 从 xi 到 xi+1 在图中有一条有向边。路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。
 *
 * 请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。
 *
 */


public class Largest_Color_Value_in_a_Directed_Graph {


    private int largestPathValue(String colors, int[][] edges){

        int n = colors.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //记录每个节点的入度
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (from == to){
                return -1;
            }
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //将入度为0的节点，加入队列，方便下面的广度优先遍历
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }

        int processnodes = 0;
        int maxcount = 0;
        int[][] dp = new int[n][26];

        while (!queue.isEmpty()){
            //弹出队列头
            int from = queue.poll();
            processnodes++;
            dp[from][colors.charAt(from)-'a']++;
            maxcount = Math.max(maxcount, dp[from][colors.charAt(from)-'a']);

            for (int to : graph.get(from)) {

                for (int i = 0; i < 26; i++) {
                    dp[to][i] = Math.max(dp[to][i], dp[from][i]);
                }
                if (--inDegree[to] == 0){
                    queue.add(to);
                }
            }
        }
        if (processnodes < n){
            return -1;
        }
        return maxcount;
    }



    private int largestPathValue_2(String colors, int[][] edges){
        int n = colors.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] inDegrees = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (from == to){
                return -1;
            }

            graph.get(from).add(to);
            inDegrees[to]++;
        }

        int[][] dp = new int[n][26];
        int maxcount = 0;
        int processnode = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int from = queue.poll();
            processnode++;

            dp[from][colors.charAt(from)-'a']++;
            maxcount = Math.max(maxcount, dp[from][colors.charAt(from)-'a']);

            for (int to : graph.get(from)) {

                for (int i = 0; i < 26; i++) {
                    dp[to][i] = Math.max(dp[to][i], dp[from][i]);
                }
                if (--inDegrees[to] == 0){
                    queue.add(to);
                }
            }
        }
        if (processnode < n){
            return -1;
        }
        return maxcount;
    }


}
