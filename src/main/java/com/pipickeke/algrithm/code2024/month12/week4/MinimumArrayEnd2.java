package com.pipickeke.algrithm.code2024.month12.week4;

public class MinimumArrayEnd2 {

    private long minEnd(int n, int x){
        long ans = x;
        n--;
        int i=0;
        int j=0;
        while ( (n >> j) != 0){
            if ( (ans >> i & 1) == 0 ){
                ans |= (long) (n >> j & 1) << i;
                j++;
            }
            i++;
        }
        return ans;
    }
}
