package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 题目：生成不含相邻零的二进制字符串
 *
 * 给你一个正整数 n。
 *
 * 如果一个二进制字符串 x 的所有长度为 2 的
 * 子字符串
 * 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
 *
 * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 *
 */

public class Generate_Binary_Strings_Without_Adjacent_Zeros {

    public static void main(String[] args) {
        Generate_Binary_Strings_Without_Adjacent_Zeros bean = new Generate_Binary_Strings_Without_Adjacent_Zeros();
        int n = 3;
        System.out.println(bean.validStrings(n));
    }

    private List<String> validStrings(int n){
        dfs(new StringBuilder(), n);
        return list;
    }

    private List<String> list = new ArrayList<>();
    private void dfs(StringBuilder sb, int n){
        if (sb.length() == n){
            list.add(sb.toString());
        } else {
            if (sb.length() == 0 || sb.charAt(sb.length()-1) == '1'){
                sb.append('0');
                dfs(sb, n);
                sb.setLength(sb.length()-1);
            }
            sb.append("1");
            dfs(sb, n);
            sb.setLength(sb.length()-1);
        }
    }

}
