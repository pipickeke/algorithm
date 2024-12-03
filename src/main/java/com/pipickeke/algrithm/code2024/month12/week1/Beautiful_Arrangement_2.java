package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.ArrayList;
import java.util.List;

public class Beautiful_Arrangement_2 {

    public static void main(String[] args) {
        Beautiful_Arrangement_2 bean = new Beautiful_Arrangement_2();
        int num = 2;
        System.out.println(bean.countArrangement(num));
    }


    private List<Integer>[] match;
    private boolean[] vis;
    private int ans;
    private int countArrangement(int n){
        match = new List[n+1];
        vis = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ( i%j ==0 || j%i ==0 ){
                    match[i].add(j);
                }
            }
        }
        dfs(1,n);
        return ans;
    }

    private void dfs(int index, int n){
        if (index == n+1){
            ans++;
            return;
        }
        for (Integer item : match[index]) {
            if (!vis[item]){
                vis[item] = true;
                dfs(index+1, n);
                vis[item] = false;
            }
        }
    }
}
