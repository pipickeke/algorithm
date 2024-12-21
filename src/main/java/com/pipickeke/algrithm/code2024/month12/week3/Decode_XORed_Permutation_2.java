package com.pipickeke.algrithm.code2024.month12.week3;

public class Decode_XORed_Permutation_2 {

    private int[] decode(int[] encoded){

        int N = encoded.length+1;
        int[] ans = new int[N];

        int a = 0;
        for (int i = 0; i < N - 1; i += 2) {
            a ^= encoded[i];
        }

        int b = 0;
        for (int i = 1; i <= N; i++) {
            b ^= i;
        }

        ans[N-1] = a ^ b;

        for (int i = N-2; i >= 0; i--) {
            ans[i] = ans[i+1] ^ encoded[i];
        }
        return ans;
    }
}
