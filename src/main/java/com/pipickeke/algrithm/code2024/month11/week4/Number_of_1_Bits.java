package com.pipickeke.algrithm.code2024.month11.week4;

/**
 *  题目： 位1的个数
 */
public class Number_of_1_Bits {

    public static void main(String[] args) {
        int num = 3;
        Number_of_1_Bits bean = new Number_of_1_Bits();
        System.out.println(bean.hammingWeight(num));
    }

    private int hammingWeight(int n){
        int cnt = 0;
        for (int i = 31; i >= 0; i--) {
            cnt += (n & (1 <<i)) == 0 ? 0 : 1;
        }
        return cnt;
    }
}
