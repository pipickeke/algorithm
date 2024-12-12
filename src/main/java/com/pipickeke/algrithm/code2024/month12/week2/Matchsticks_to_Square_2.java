package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.Arrays;


/**
 *
 *  *  题目：火柴拼正方形
 *  *
 *  *  你将得到一个整数数组 matchsticks ，其中 matchsticks[i]
 *  *  是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。
 *  *  你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *  *
 *  * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 */
public class Matchsticks_to_Square_2 {

    private boolean makesquare(int[] matchsticks){
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0){
            return false;
        }

        Arrays.sort(matchsticks);

        for (int i = 0, j = matchsticks.length-1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        int[] edge = new int[4];
        return dfs(0, edge, matchsticks, sum/4);
    }

    private boolean dfs(int index, int[] edges, int[] match, int len){
        if (index == match.length){
            return true;
        }

        for (int i = 0; i < edges.length; i++) {
            edges[i] += match[index];
            if (edges[i] <= len && dfs(index+1, edges, match, len)){
                return true;
            }
            edges[i] -= match[index];
        }
        return false;
    }



}
