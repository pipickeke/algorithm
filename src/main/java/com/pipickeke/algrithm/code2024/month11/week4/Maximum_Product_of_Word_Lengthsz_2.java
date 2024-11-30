package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.Map;

public class Maximum_Product_of_Word_Lengthsz_2 {

    public static void main(String[] args) {
        Maximum_Product_of_Word_Lengthsz_2 bean = new Maximum_Product_of_Word_Lengthsz_2();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(bean.maxProduct(words));
    }

    private int maxProduct(String[] words) {
        int N = words.length;
        int[] mask = new int[N];

        for (int i = 0; i < N; i++) {
            String word = words[i];
            int cur = 0;
            for (int j = 0; j < word.length(); j++) {
                cur = cur | (1 << (word.charAt(j) - 'a'));
            }
            mask[i] = cur;
        }

        int ant = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ant = Math.max(ant, words[i].length() * words[j].length());
                }
            }
        }
        return ant;
    }
}
