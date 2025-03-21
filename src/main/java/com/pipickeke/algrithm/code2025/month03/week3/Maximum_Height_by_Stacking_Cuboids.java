package com.pipickeke.algrithm.code2025.month03.week3;

import com.pipickeke.algrithm.code2025.month02.week4.MaximumAbsoluteSumofAnySubarray;

import java.util.Arrays;
import java.util.Collections;


/**
 * 题目：1691. 堆叠长方体的最大高度
 *
 * 给你 n 个长方体 cuboids ，其中第 i 个长方体的长宽高表示为 cuboids[i] = [widthi, lengthi, heighti]（下标从 0 开始）。请你从 cuboids 选出一个 子集 ，并将它们堆叠起来。
 *
 * 如果 widthi <= widthj 且 lengthi <= lengthj 且 heighti <= heightj ，你就可以将长方体 i 堆叠在长方体 j 上。你可以通过旋转把长方体的长宽高重新排列，以将它放在另一个长方体上。
 *
 * 返回 堆叠长方体 cuboids 可以得到的 最大高度 。
 *
 */


public class Maximum_Height_by_Stacking_Cuboids {



    private int maxHeight(int[][] cuboids){
        int n = cuboids.length;
        for (int[] row : cuboids) {
            Arrays.sort(row);
        }

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (x,y) -> cuboids[x][0] != cuboids[y][0] ?
                cuboids[x][0] - cuboids[y][0] : cuboids[x][1] != cuboids[y][1] ?
                cuboids[x][1] - cuboids[y][1] : cuboids[x][2] - cuboids[y][2]);

        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[idx[j]][1] <= cuboids[idx[i]][1] &&
                cuboids[idx[j]][2] <= cuboids[idx[i]][2]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += cuboids[idx[i]][2];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
