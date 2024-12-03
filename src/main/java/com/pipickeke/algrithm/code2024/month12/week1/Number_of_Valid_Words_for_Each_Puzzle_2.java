package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_of_Valid_Words_for_Each_Puzzle_2 {

    public static void main(String[] args) {
        Number_of_Valid_Words_for_Each_Puzzle_2 bean = new Number_of_Valid_Words_for_Each_Puzzle_2();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(bean.findNumOfValidWords(words, puzzles));
    }

    private List<Integer> findNumOfValidWords(String[] words, String[] puzzles){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int mask = 0;

            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                mask |= (1 << (word.charAt(j) - 'a'));
            }
            if (Integer.bitCount(mask) <= 7){
                frequencyMap.put(mask, frequencyMap.getOrDefault(mask,0)+1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int total = 0;

            String puzzle = puzzles[i];

            int mask_2 = 0;
            for (int j = 1; j < 7; j++) {
                mask_2 |= (1 << (puzzle.charAt(j) - 'a'));
            }

            int subset = mask_2;
            do {

                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequencyMap.containsKey(s)){
                    total += frequencyMap.get(s);
                }
                subset = (subset - 1) & mask_2;
            } while (subset != mask_2);

            ans.add(total);
        }

        return ans;
    }
}
