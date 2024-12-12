package com.pipickeke.algrithm.code2024.month12.week2;

public class Complement_of_Base_10_Integer {

    public static void main(String[] args) {
        Complement_of_Base_10_Integer bean = new Complement_of_Base_10_Integer();
        int num = 5;
        bean.printBit(num);
        bean.printBit(bean.bitwiseComplement(num));

    }

    private void printBit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1 <<i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    private int bitwiseComplement(int n){
        if (n == 0){
            return 1;
        }
        int ans = 0;
        int cnt = 0;
        while (n != 0){
            ans = (n &1) == 1 ? ans : ans | (1 <<cnt);
            cnt++;
            n >>=1;
        }
        return ans;
    }
}
