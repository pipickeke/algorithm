package com.pipickeke.algrithm.code2024.month12.week1;

public class HammingWeight {

    public static void main(String[] args) {

    }

    private int hammingWeight(int n){
        int ans = 0;
        while (n != 0){
            ans += (n &1) == 1 ? 1:0;
            n >>>=1;
        }
        return ans;
    }
}
