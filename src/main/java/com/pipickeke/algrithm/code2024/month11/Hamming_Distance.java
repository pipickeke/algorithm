package com.pipickeke.algrithm.code2024.month11;

/**
 *  题目：汉明距离
 *  两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *  给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 */
public class Hamming_Distance {

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hanming(x, y));
    }

    private static int hanming(int x, int y){
        int ans = 0;
        int n = 31;
        while ( n >= 0 ){
            ans += (x & 1) == (y & 1) ? 0 : 1;
            x>>= 1;
            y>>= 1;
            n--;
        }
        return ans;
    }
}
