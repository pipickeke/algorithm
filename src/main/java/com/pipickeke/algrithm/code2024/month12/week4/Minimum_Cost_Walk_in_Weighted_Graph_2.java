package com.pipickeke.algrithm.code2024.month12.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：3108. 带权图里旅途的最小代价
 *
 * 给你一个 n 个节点的带权无向图，节点编号为 0 到 n - 1 。
 *
 * 给你一个整数 n 和一个数组 edges ，其中 edges[i] = [ui, vi, wi] 表示节点 ui 和 vi 之间有一条权值为 wi 的无向边。
 *
 * 在图中，一趟旅途包含一系列节点和边。旅途开始和结束点都是图中的节点，且图中存在连接旅途中相邻节点的边。注意，一趟旅途可能访问同一条边或者同一个节点多次。
 *
 * 如果旅途开始于节点 u ，结束于节点 v ，我们定义这一趟旅途的 代价 是经过的边权按位与 AND 的结果。换句话说，如果经过的边对应的边权为 w0, w1, w2, ..., wk ，那么代价为w0 & w1 & w2 & ... & wk ，其中 & 表示按位与 AND 操作。
 *
 * 给你一个二维数组 query ，其中 query[i] = [si, ti] 。对于每一个查询，你需要找出从节点开始 si ，在节点 ti 处结束的旅途的最小代价。如果不存在这样的旅途，答案为 -1 。
 *
 * 返回数组 answer ，其中 answer[i] 表示对于查询 i 的 最小 旅途代价。
 *
 */

public class Minimum_Cost_Walk_in_Weighted_Graph_2 {


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

        int[] ring = new int[n];
        Arrays.fill(ring,-1);
        ArrayList<Integer> ringAndSum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ring[i] < 0){
                ringAndSum.add(dfs(i, ringAndSum.size(), graph, ring));
            }
        }

        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] item = query[i];
            int s = item[0];
            int t = item[1];
            res[i] = ring[s] != ring[t] ? -1 : ringAndSum.get(ring[s]);
        }
        return res;

    }

    private int dfs(int x, int ringId, List<int[]>[] graph, int[] ring){
        ring[x] = ringId;
        int andsum = -1;
        for (int[] vertex : graph[x]) {
            int end = vertex[0];
            int w = vertex[1];
            andsum &= w;
            if (ring[end] < 0){
                andsum &= dfs(vertex[0], ringId, graph,ring);
            }
        }
        return andsum;
    }
}
