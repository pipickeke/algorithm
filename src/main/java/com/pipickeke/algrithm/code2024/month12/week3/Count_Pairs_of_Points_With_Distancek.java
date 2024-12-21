package com.pipickeke.algrithm.code2024.month12.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 题目：2857. 统计距离为 k 的点对
 *
 * 给你一个 二维 整数数组 coordinates 和一个整数 k ，
 * 其中 coordinates[i] = [xi, yi] 是第 i 个点在二维平面里的坐标。
 *
 * 我们定义两个点 (x1, y1) 和 (x2, y2) 的 距离 为 (x1 XOR x2) + (y1 XOR y2) ，XOR 指的是按位异或运算。
 *
 * 请你返回满足 i < j 且点 i 和点 j之间距离为 k 的点对数目。
 *
 */

public class Count_Pairs_of_Points_With_Distancek {

    public static void main(String[] args) {
    }

    private int countPairs(List<List<Integer>> coordinates, int k){

        int ans = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < coordinates.size(); i++) {
            List<Integer> curList = coordinates.get(i);
            int x = curList.get(0);
            int y = curList.get(1);

            for (int j = 0; j <= k; j++) {
                ans += map.getOrDefault(2000000L * (x ^ j) + y ^ (k-j), 0);
            }
            map.merge(x * 2000000L + y, 1, Integer::sum);
        }
        return ans;

    }
}
