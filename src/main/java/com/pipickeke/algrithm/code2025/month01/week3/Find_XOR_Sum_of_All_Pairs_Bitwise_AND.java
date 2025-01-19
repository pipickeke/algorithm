package com.pipickeke.algrithm.code2025.month01.week3;


/**
 * 题目：1835. 所有数对按位与结果的异或和
 * 标签：恒等式
 *
 * 列表的 异或和（XOR sum）指对所有元素进行按位 XOR 运算的结果。如果列表中仅有一个元素，
 * 那么其 异或和 就等于该元素。
 *
 * 例如，[1,2,3,4] 的 异或和 等于 1 XOR 2 XOR 3 XOR 4 = 4 ，而 [3] 的 异或和 等于 3 。
 * 给你两个下标 从 0 开始 计数的数组 arr1 和 arr2 ，两数组均由非负整数组成。
 *
 * 根据每个 (i, j) 数对，构造一个由 arr1[i] AND arr2[j]（按位 AND 运算）结果组成的列表。
 * 其中 0 <= i < arr1.length 且 0 <= j < arr2.length 。
 *
 * 返回上述列表的 异或和 。
 *
 */

public class Find_XOR_Sum_of_All_Pairs_Bitwise_AND {

    private int getXORSum(int[] arr1, int[] arr2){
        int xorsum1 = 0;
        for (int x : arr1) {
            xorsum1 ^= x;
        }
        int xorsum2 = 0;
        for (int y : arr2) {
            xorsum2 ^= y;
        }
        return xorsum1 & xorsum2;
    }
}
