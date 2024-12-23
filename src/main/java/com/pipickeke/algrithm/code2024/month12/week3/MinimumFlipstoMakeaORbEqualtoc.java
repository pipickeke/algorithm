package com.pipickeke.algrithm.code2024.month12.week3;

public class MinimumFlipstoMakeaORbEqualtoc {

    public static void main(String[] args) {
        MinimumFlipstoMakeaORbEqualtoc bean = new MinimumFlipstoMakeaORbEqualtoc();
        int a = 4;
        int b = 2;
        int c = 7;
        System.out.println(bean.minFlips(a, b, c));
    }

    private int minFlips(int a, int b, int c){

        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bitc = (c & (1 <<i)) == 0 ? 0 : 1;
            int bita = (a & (1 <<i)) == 0 ? 0 : 1;
            int bitb = (b & (1 <<i)) == 0 ? 0 : 1;

            if ( (bita | bitb) != bitc ){
                if (bitc == 0){
                    res += (bita & bitb) == 1 ? 2 : 1;
                } else {
                    res += (bita | bitb) == 1 ? 0 : 1;
                }
            }
        }
        return res;
    }
}
