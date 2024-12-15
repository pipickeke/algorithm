package com.pipickeke.algrithm.code2024.month12.week2;

public class XOR_Operation_in_an_Array {

    private int xorOperation(int n, int start){
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= (start + 2*i);
        }
        return ans;
    }
}
