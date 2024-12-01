package com.pipickeke.algrithm.code2024.month11.week4;


/**
 *  题目：4的幂
 *  给定一个整数，写一个函数来判断它是否是 4 的幂次方。
 *  如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  思路：
 *  n 是4的幂，肯定首先是2的幂，
 *      2的幂肯定是正整数，然后其二进制表达中肯定只有1个1，
 *      可以通过 n & (n-1) == 0 判断是否是2的mi
 *  4的幂，可以二进制表达只有1个1，
 *      且1后面跟的是偶数个0，1都在奇数位上，
 *      可以创建掩码： (1010 1010, 1010 1010, 1010 1010, 1010 1010)2
 *      可以转换为16进制：0xaaaaaaaa
 */
public class Power_of_Four {

    public static void main(String[] args) {
        Power_of_Four bean = new Power_of_Four();
        System.out.println(bean.isPowerOfFour(16));
    }

    private boolean isPowerOfFour(int n){
        return n > 0 && ( (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0 );
    }
}
