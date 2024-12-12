package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.ArrayList;
import java.util.List;

public class Generate_Binary_Strings_Without_Adjacent_Zeros_2 {


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
            sb.append('1');
            dfs(sb, n);
            sb.setLength(sb.length()-1);
        }
    }
}
