package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：2429. 最小异或
 *
 * 给你两个正整数 num1 和 num2 ，找出满足下述条件的正整数 x ：
 *
 * x 的置位数和 num2 相同，且
 * x XOR num1 的值 最小
 * 注意 XOR 是按位异或运算。
 *
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 *
 * 整数的 置位数 是其二进制表示中 1 的数目。
 *
 * 思路：c1 => num1中 1的个数，c2 => num2中1的个数
 *      如果 c2 > c1，则可以将num1高位全部覆盖，多余的1只能填在低位。
 *                  相当于x =>  num1 将低位的0，不断变成1，直到 c2==c1
 *      如果 c2 < c1, 肯定是从num1高位去服务，不够的 c1-c2，只能是0
 *                  相当于x => num1 将低位的1，不断变成0, 直到 c2==c1
 *      其他情况  x=num1
 */
public class Minimize_XOR {

    public static void main(String[] args) {
        Minimize_XOR bean = new Minimize_XOR();
        int num1 = 3;
        int num2 = 5;
        bean.printBit(num1);
        System.out.println(bean.minimizeXor(num1, num2));
    }

    private void printBit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1 <<i)) == 0 ? "0" : "1" );
        }
        System.out.println();
    }

    private int minimizeXor(int num1, int num2){

        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        while (c2 < c1){
            num1 &= (num1 - 1); //把低位的1变成0
            c2++;
        }
        while (c2 > c1){
            num1 |= (num1 + 1); //把低位的0变成1
            c2--;
        }
        return num1;
    }
}
