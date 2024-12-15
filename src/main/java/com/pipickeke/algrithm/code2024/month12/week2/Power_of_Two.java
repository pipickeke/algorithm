package com.pipickeke.algrithm.code2024.month12.week2;

public class Power_of_Two {

    private boolean isPowerOfTwo(int n){
        return n > 0 && (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
