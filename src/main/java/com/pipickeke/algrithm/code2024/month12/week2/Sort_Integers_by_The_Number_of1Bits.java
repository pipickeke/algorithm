package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 * 题目：根据数字二进制下 1 的数目排序
 *
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 */
public class Sort_Integers_by_The_Number_of1Bits {

    public static void main(String[] args) {
        Sort_Integers_by_The_Number_of1Bits bean = new Sort_Integers_by_The_Number_of1Bits();
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(bean.sortByBits(arr)));
    }

    private int[] sortByBits(int[] arr){
        int[] bits = new int[10001];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            bits[arr[i]] = getBit(arr[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bits[o1] != bits[o2]){
                    return bits[o1] - bits[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getBit(int num){
        int ans = 0;
        while (num != 0){
            ans += (num&1) == 1 ? 1 : 0;
            num >>=1;
        }
        return ans;
    }


}
