package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.ArrayList;
import java.util.List;

public class Binary_Watch {

    public static void main(String[] args) {
        Binary_Watch bean = new Binary_Watch();
        int num = 1;
        System.out.println(bean.readBinaryWatch(num));
    }

    private List<String> readBinaryWatch(int turnedOn){
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    ans.add(i + ":" + (j < 10 ? "0":"") + j);
                }
            }
        }
        return ans;
    }
}
