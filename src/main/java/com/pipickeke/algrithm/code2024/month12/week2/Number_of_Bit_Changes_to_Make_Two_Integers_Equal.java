package com.pipickeke.algrithm.code2024.month12.week2;


/**
 *  题目：使两个整数相等的位更改次数
 *
 *  给你两个正整数 n 和 k。
 *
 * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
 *
 * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
 *
 */
public class Number_of_Bit_Changes_to_Make_Two_Integers_Equal {

    public static void main(String[] args) {
        int a = 11;
        int b = 56;
        Number_of_Bit_Changes_to_Make_Two_Integers_Equal bean = new Number_of_Bit_Changes_to_Make_Two_Integers_Equal();
        bean.printBit(a);
        bean.printBit(b);
        System.out.println(bean.minChanges(a, b));
    }

    private void printBit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1<<i)) == 0 ? "0" : "1" );
        }
        System.out.println();
    }

    private int minChanges(int n, int k){
        int ans = 0;
        while (n != 0 || k != 0){
            int cur1 = n & 1;
            int cur2 = k & 1;
            if ((cur1 ^ cur2) == 1){
                if (cur1 == 0){
                    return -1;
                }
                ans++;
            }
            n>>=1;
            k>>=1;
        }
        return ans;
    }
}
