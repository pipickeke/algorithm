package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：2053. 数组中第 K 个独一无二的字符串
 *
 * 独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
 *
 * 给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
 *
 * 注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。
 *
 */

public class Kth_Distinct_String_in_an_Array {


    public String kthDistinct(String[] arr, int k){

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) +1);
        }
        for (String str : arr) {
            if (map.get(str) == 1){
                k--;
                if (k == 0){
                    return str;
                }
            }
        }
        return "";
    }
}
