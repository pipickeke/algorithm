package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.ArrayList;
import java.util.List;


public class Gray_Code {

    public static void main(String[] args) {
        int n = 3;
        Gray_Code bean = new Gray_Code();
//        System.out.println(bean.gray2(n));
        System.out.println(bean.gray3(n));
    }

    private static List<Integer> grayCode(int n){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (n-- > 0){
            int m = list.size();
            for (int i = m-1; i >= 0; i--) {
                list.set(i, list.get(i) <<1);
                list.add(list.get(i)+1);
            }
        }
        return list;
    }


    private List<Integer> res = new ArrayList<>();
    private List<Integer> gray2(int n){
        dfs(n, new StringBuilder(), new int[]{0,1});
        return res;
    }

    private void dfs(int n, StringBuilder sb, int[] nums){
        if (sb.length() == n){
            res.add(Integer.valueOf(sb.toString(), 2));
            return;
        }

        sb.append(nums[0]);
        dfs(n, sb, new int[]{0,1});
        sb.deleteCharAt(sb.length()-1);

        sb.append(nums[1]);
        dfs(n, sb, new int[]{1,0});
        sb.deleteCharAt(sb.length()-1);

    }

    private List<Integer> gray3(int n){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        while (n-- > 0){
            int m = res.size();
            for (int i = m-1; i >= 0; i--) {
                res.set(i, res.get(i) <<1);
                res.add(res.get(i)+1);
            }
        }
        return res;
    }
}
