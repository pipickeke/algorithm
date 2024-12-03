package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_of_Valid_Words_for_Each_Puzzle {

    public static void main(String[] args) {
        Number_of_Valid_Words_for_Each_Puzzle bean = new Number_of_Valid_Words_for_Each_Puzzle();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(bean.findNumOfValidWords(words, puzzles));
    }

    private List<Integer> findNumOfValidWords(String[] words, String[] puzzles){

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= (1 << (word.charAt(j) - 'a'));
            }
            if (Integer.bitCount(mask) <= 7){
                frequencyMap.put(mask, frequencyMap.getOrDefault(mask,0)+1);
            }
        }

        for (int i = 0; i < puzzles.length; i++) {
            int ans = 0;
            String puzzle = puzzles[i];

            int mask = 0;
            //puzzle首字母肯定在，此次忽略
            for (int j = 1; j < 7; j++) {
                mask |= (1 << (puzzle.charAt(j) - 'a'));
            }

            //枚举mask的子集
            int subset = mask;
            do {

                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequencyMap.containsKey(s)){
                    ans += frequencyMap.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            list.add(ans);
        }
        return list;
    }
}





