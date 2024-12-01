package com.pipickeke.algrithm.code2024.month11.week4;

public class Number_Complement {

    public static void main(String[] args) {
        Number_Complement bean = new Number_Complement();
        int num = 5;
        System.out.println(bean.findComplement(num));
    }

    private int findComplement(int num){

        int ant = 0;
        int cnt = 0;
        while (num != 0){

            if ( (num & 1) == 0 ){
                ant |= (1 <<cnt);
            }
            num >>>=1;
            cnt++;
        }
        return ant;
    }
}
