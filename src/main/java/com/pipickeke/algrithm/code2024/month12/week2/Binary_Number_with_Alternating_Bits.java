package com.pipickeke.algrithm.code2024.month12.week2;

/**
 *
 * 题目： 交替位二进制数
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：
 * 换句话说，就是二进制表示中相邻两位的数字永不相同。
 */

public class Binary_Number_with_Alternating_Bits {

    public static void main(String[] args) {
        int num = 5;
        Binary_Number_with_Alternating_Bits bean = new Binary_Number_with_Alternating_Bits();
        bean.printBit(num);
        System.out.println(bean.hasAlternatingBits(num));
    }

    private void printBit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1 <<i)) == 0 ? "0" : "1" );
        }
        System.out.println();
    }

    private boolean hasAlternatingBits(int n){
        int flag = n & 1;
        n >>=1;
        while (n != 0){
            if (flag == (n&1)){
                return false;
            }
            flag = n&1;
            n >>=1;
        }
        return true;
    }
}
