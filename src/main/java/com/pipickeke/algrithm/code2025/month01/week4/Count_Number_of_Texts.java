package com.pipickeke.algrithm.code2025.month01.week4;

public class Count_Number_of_Texts {


    private int countTexts(String pressedKeys){
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            cnt++;
            char x = pressedKeys.charAt(i);
            if (i == pressedKeys.length()-1 || x != pressedKeys.charAt(i+1)){
                ans = ans * ((x != '7' && x != '9') ? f[cnt] : g[cnt] )% MOD;
                cnt = 0;
            }
        }
        return (int) ans;
    }

    private static final int MX = 100001;
    private static final int MOD = 100000007;
    private static long[] f = new long[MX];
    private static long[] g = new long[MX];

    static {
        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i < MX; i++) {
            f[i] = (f[i-1] + f[i-2] + f[i-3]) %MOD;
            g[i] = (g[i-1] + g[i-2] + g[i-3] + g[i-4]) %MOD;
        }
    }
}
