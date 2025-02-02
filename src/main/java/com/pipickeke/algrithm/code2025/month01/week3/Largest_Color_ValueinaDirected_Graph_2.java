package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Largest_Color_ValueinaDirected_Graph_2 {


    private int largestPathValue(String colors, int[][] edges){

        int N = colors.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegress = new int[N];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (from == to){
                return -1;
            }

            graph.get(from).add(to);
            inDegress[to]++;
        }

        //记录入度=0的顶点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegress.length; i++) {
            if (inDegress[i] == 0){
                queue.add(i);
            }
        }

        //记录经过每个顶点的路径，每种颜色最多有多少
        int[][] dp = new int[N][26];

        int maxcount = 0;
        int node = 0;
        while (!queue.isEmpty()){
            int from = queue.poll();
            dp[from][colors.charAt(from)-'a']++;
            node++;

            maxcount = Math.max(maxcount, dp[from][colors.charAt(from)-'a']);

            //广度遍历
            for (int to : graph.get(from)) {
                //尝试判断26中颜色
                for (int i = 0; i < 26; i++) {
                    dp[to][i] = Math.max(dp[to][i], dp[from][i]);
                }
                if (--inDegress[to] == 0){
                    queue.add(to);
                }
            }
        }
        if (node < N){
            return -1;
        }
        return maxcount;
    }
}
