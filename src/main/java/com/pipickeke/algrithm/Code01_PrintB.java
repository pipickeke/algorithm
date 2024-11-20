package com.pipickeke.algrithm;

//todo 打印数字的二进制32位表示
public class Code01_PrintB {

    public static void main(String[] args) {
        int num = 10;
        print(num);
    }

    private static void print(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1 << i)) == 0 ? "0" : "1" );
        }
        System.out.println();
    }

}
