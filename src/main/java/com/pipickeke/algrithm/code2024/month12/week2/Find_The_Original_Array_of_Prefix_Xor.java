package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.Arrays;


/**
 * 题目： 找出前缀异或的原始数组
 *
 * 给你一个长度为 n 的 整数 数组 pref 。
 * 找出并返回满足下述条件且长度为 n 的数组 arr ：
 *
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * 注意 ^ 表示 按位异或（bitwise-xor）运算。
 *
 * 可以证明答案是 唯一 的。
 */

public class Find_The_Original_Array_of_Prefix_Xor {

    public static void main(String[] args) {
        Find_The_Original_Array_of_Prefix_Xor bean = new Find_The_Original_Array_of_Prefix_Xor();
        int[] arr = {5,2,0,3,1};
        System.out.println(Arrays.toString(bean.findArray(arr)));
    }

    private int[] findArray(int[] pref){
        int[] ans = new int[pref.length];
        ans[0] =  pref[0];

        int xor = ans[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = pref[i] ^ xor;
            xor ^= ans[i];
        }
        return ans;
    }
}
