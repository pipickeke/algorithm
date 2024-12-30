package com.pipickeke.algrithm.code2024.month12.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Cost_Walk_in_Weighted_Graph_3 {

    private int[] minimumCost(int n, int[][] edges, int[][] query){
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            graph[x].add(new int[]{y,w});
            graph[y].add(new int[]{x,w});
        }

        //记录每个顶点，属于那个连通的环
        int[] ring = new int[n];
        Arrays.fill(ring,-1);
        //记录每个环的 累加与和
        ArrayList<Integer> andsum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //当前顶点，没有尝试过，即不属于任何环，才去尝试
            if (ring[i] < 0){
                andsum.add(dfs(i, andsum.size(),ring,graph));
            }
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] item = query[i];
            int x = item[0];
            int y = item[1];
            ans[i] = ring[x] == ring[y] ? andsum.get(ring[x]) : -1;
        }
        return ans;
    }

    private int dfs(int i, int ringId, int[] ring, List<int[]>[] graph){
        ring[i] = ringId;
        int andsum = -1;
        for (int[] vertex : graph[i]) {
            int j = vertex[0];
            int w = vertex[1];
            andsum &= w;
            //当 j 没有被访问过，则继续去 j点  尝试
            if (ring[j] < 0){
                andsum &= dfs(j, ringId, ring, graph);
            }
        }
        return andsum;
    }
}
