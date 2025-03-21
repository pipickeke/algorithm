package com.pipickeke.algrithm.code2025.month03.week3;

import java.util.Arrays;


/**
 * 1626. 无矛盾的最佳球队
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 *
 *
 */

public class Best_Team_With_No_Conflicts {



    private int bestTeamScore(int[] scores, int[] ages){
        int n = scores.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (x,y) -> scores[x] != scores[y] ?
                scores[x] - scores[y] : ages[x] - ages[y]);

        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ages[idx[j]] <= ages[idx[i]]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += scores[idx[i]];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
