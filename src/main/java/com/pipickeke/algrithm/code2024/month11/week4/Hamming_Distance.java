package com.pipickeke.algrithm.code2024.month11.week4;

public class Hamming_Distance {

    public static void main(String[] args) {

    }

    private int hammingDistance(int start, int goal){
        int xor = start ^ goal;
        int cnt = 0;
        while (xor != 0){
            cnt += (xor &1) == 0 ? 0 : 1;
            xor >>>=1;
        }
        return cnt;
    }
}
