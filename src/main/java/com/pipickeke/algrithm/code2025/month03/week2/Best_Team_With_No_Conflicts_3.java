package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Best_Team_With_No_Conflicts_3 {


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
