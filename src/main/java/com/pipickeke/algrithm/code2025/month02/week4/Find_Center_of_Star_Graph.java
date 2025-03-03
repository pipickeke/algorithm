package com.pipickeke.algrithm.code2025.month02.week4;

import java.util.HashSet;

/**
 * 题目：1791. 找出星型图的中心节点
 *
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 *
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
 *
 *
 */

public class Find_Center_of_Star_Graph {


    private int findCenter(int[][] edges){

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            int l = edges[i][0];
            int r = edges[i][1];
            if (set.contains(l)){
                return l;
            }
            if (set.contains(r)){
                return r;
            }
            set.add(l);
            set.add(r);
        }
        return -1;
    }
}
