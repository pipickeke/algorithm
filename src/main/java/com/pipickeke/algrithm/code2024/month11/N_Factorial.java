package com.pipickeke.algrithm.code2024.month11;

/**
 * N 阶乘
 * 1! + 2! + 3! +....N!
 *
 * 思路：
 * 下一次的阶乘，只是上一次的阶乘结果，再乘上当前循环到的N
 *
 */
public class N_Factorial {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(fac(num));
    }

    private static int fac(int N){
        int ans = 0;
        int cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }
}
