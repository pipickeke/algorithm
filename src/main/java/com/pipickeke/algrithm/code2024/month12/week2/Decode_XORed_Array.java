package com.pipickeke.algrithm.code2024.month12.week2;


/**
 * 题目：解码异或后的数组
 *
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，
 * 其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 */
public class Decode_XORed_Array {

    private int[] decode(int[] encoded, int first){

        int[] ans = new int[encoded.length+1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = encoded[i-1] ^ ans[i-1];
        }
        return ans;
    }
}
