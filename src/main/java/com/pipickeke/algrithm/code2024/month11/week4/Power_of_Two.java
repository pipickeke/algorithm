package com.pipickeke.algrithm.code2024.month11.week4;


/**
 *  题目：2 的幂
 *  给你一个整数 n，请你判断该整数是否是 2 的幂次方。
 *  如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，
 * 则认为 n 是 2 的幂次方。
 *
 */
public class Power_of_Two {

    public static void main(String[] args) {

    }

    private boolean isPowerOfTwo(int n){
        if (n == Integer.MIN_VALUE){
            return false;
        }
        for (int i = 0; i < 32; i++) {
            if (n == (1 <<i)){
                return true;
            }
        }
        return false;
    }
}
