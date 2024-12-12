package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.Arrays;


/**
 *  题目：火柴拼正方形
 *
 *  你将得到一个整数数组 matchsticks ，其中 matchsticks[i]
 *  是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。
 *  你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 *  思路：
 *      （1）首先可以判断火柴 match[] 的总和 sum，如果无法被4整除，则肯定是 false
 *      （2）在可以被4整除的基础上，正方形的每个边长是  sum/4
 *      (3) 然后去尝试，每个边 edges[i]，在选择当前这根火柴 match[index]后
 *          edges[i]+match[index] 是否达到 边长 sum/4，
 *          如果达到，或者小于等于。则选择当前这根火柴放在这个边上是可以的，
 *          接下来去尝试下一根火柴index+1.
 *       (4)当前这个边 edge[i] 在尝试放火柴 match[index] 尝试失败后，
 *          需要放回火柴， edge[i] -= match[index]
 */
public class Matchsticks_to_Square {

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

        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, sum/4);
    }

    private boolean dfs(int index, int[] matchsticks, int[] edges, int len){
        if (index == matchsticks.length){
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index+1, matchsticks, edges, len)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }




}
