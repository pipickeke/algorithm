package com.pipickeke.algrithm.code2025.month01.week1;

/**
 * 题目：1521. 找到最接近目标值的函数值
 *
 * Winston 构造了一个如上所示的函数 func 。他有一个整数数组 arr 和一个整数 target ，
 * 他想找到让 |func(arr, l, r) - target| 最小的 l 和 r 。
 *
 * 请你返回 |func(arr, l, r) - target| 的最小值。
 *
 * 请注意， func 的输入参数 l 和 r 需要满足 0 <= l, r < arr.length 。
 */

public class FindaValueofaMysteriousFunctionClosesttoTarget {

    private int closestToTarget(int[] arr, int target){

        int N = arr.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int x = arr[i];

            ans = Math.min(ans, Math.abs(x - target));

            for (int j = i-1; j >= 0 && (arr[j] & x) != arr[j]; j--) {
                arr[j] &= x;
                ans = Math.min(ans, Math.abs(arr[j] - target));
            }
        }
        return ans;
    }
}
