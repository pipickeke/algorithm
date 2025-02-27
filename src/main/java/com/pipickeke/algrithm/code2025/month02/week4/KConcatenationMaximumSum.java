package com.pipickeke.algrithm.code2025.month02.week4;

/**
 * 题目：1191. K 次串联后最大子数组之和
 *
 * 给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。
 *
 * 例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。
 *
 * 返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，需要返回的 109 + 7 的 模 。
 *
 *
 */

public class KConcatenationMaximumSum {

    private int kConcatenationMaxSum(int[] arr, int k){
        int mod = (int) (1e9 + 7);

        int n = arr.length;
        int[] a = new int[n * Math.min(2,k)];
        for (int i = 0; i < Math.min(2, k); i++) {
            for (int j = 0; j < n; j++) {
                a[n * i + j] = arr[j];
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        long f = 0, ans = 0;
        for (int i = 0; i < a.length; i++) {
            f = Math.max(f, 0) + a[i];
            ans = Math.max(ans, f);
        }

        if (sum > 0 && k > 2){
            ans = Math.max(ans, (long) sum * (k-2) + ans);
        }
        return (int) (ans % mod);
    }
}
