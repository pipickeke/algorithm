package com.pipickeke.algrithm.code2024.month11;

import java.util.Arrays;

/**
 *  选择排序
 *
 *  思路：
 *  从数组的左边开始，每次选择当前位置的值，和右边的每一个位置的
 *  值进行比较，找到最小值的位置，然后交换
 */
public class Selection_Sort {

    public static void main(String[] args) {
        int[] arr = {4,2,7,8,1,0,10};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    private static void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}
