package com.pipickeke.algrithm.code2025.month01.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 *
 */

public class LargestColorValueinaDirected_Graph {


    private int largestPathValue(String colors, int[][] edges){

        int N = colors.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] indegress = new int[N];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (from == to){
                return -1;
            }

            graph.get(from).add(to);
            indegress[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegress[i] == 0){
                queue.add(i);
            }
        }

        int maxcnt = 0;
        int nodes = 0;

        int[][] dp = new int[N][26];

        while (!queue.isEmpty()){
            int from = queue.poll();
            nodes++;
            dp[from][colors.charAt(from)-'a']++;
            maxcnt = Math.max(maxcnt, dp[from][colors.charAt(from)-'a']);

            for (int to : graph.get(from)) {
                for (int i = 0; i < 26; i++) {
                    dp[to][i] = Math.max(dp[to][i],
                            dp[from][i]);
                }
                if (--indegress[to] == 0){
                    queue.add(to);
                }
            }
        }
        if (nodes < N){
            return -1;
        }
        return maxcnt;
    }
}
