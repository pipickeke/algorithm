package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.Arrays;

/**
*   题目：最大单词长度乘积
 *   给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，
 *   并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
*
 *  思路：
 *      （1） 如何判断两个单词是否存在相同字母
 *      每个单词只有a-z，可以通过位图，判断每个单词中，字母是否出现
 *      一共26个字母， [0,25]位，可以使用 int 里面的低26位
 *      用 maskArr 数组，记录每个单词中，字母出现的情况
 *      如果任意两个单词，不存在相同的字母，则  maskArr[i] & markArr[j] == 0
 *      例如：
 *      abcw
 *      则可以记录为：00000000 00100000 00000000 00000111
 *      baz:
 *      则可以记录为：00000001 00000000 00000000 00000011
 *
 *      ‘abcs’ & 'baz'  != 0  ,可以判断出这两个单词存在相同字母
 *      （2）判断 len(str1) * len(str2) 最长，则通过遍历 Math.max 可以取最大值
 *
* */
public class Maximum_Product_of_Word_Lengths {

    public static void main(String[] args) {
        String[] strs = {"abcw","baz","foo","bar","xtfn","abcdef"};
        Maximum_Product_of_Word_Lengths bean = new Maximum_Product_of_Word_Lengths();
//        System.out.println(Arrays.toString(bean.getMask(strs)));
        System.out.println(bean.maxProduct(strs));
    }

    private int maxProduct(String[] words){
        int max = 0;
        int[] mask = getMask(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0 && (words[i].length() * words[j].length()) > max){
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }

    private int[] getMask(String[] words){
        int N = words.length;
        int[] maskArr = new int[N];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int dis = word.charAt(j) - 'a';
                maskArr[i] = maskArr[i] | (1 << dis);
            }
        }
        return maskArr;
    }
}
