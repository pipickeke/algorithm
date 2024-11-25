package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.Arrays;

/**
 *  题目：冒泡排序
 */
public class Bubble_Sort {

    public static void main(String[] args) {
        int[] arr = {3,1,5,7,2,0,8};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubble(int[] arr){

        int N = arr.length;
        for (int i = N-1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j-1] > arr[j]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private static void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
