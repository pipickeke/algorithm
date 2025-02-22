package com.pipickeke.algrithm.code2025.month02.week3;

/**
 * 题目：1191. K 次串联后最大子数组之和
 *
 * 给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。
 *
 * 例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。
 *
 * 返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，
 * 在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，需要返回的 109 + 7 的 模 。
 *
 *
 *
 */

public class KConcatenation_Maximum_Sum {

    private int kConcatenationMaxSum(int[] arr, int k){
        int mod = (int) (1e9 + 7);
        int n = arr.length;
        int[] a = new int[n * Math.min(2,k)];
        for (int i = 0; i < Math.min(2, k); i++) {
            for (int j = 0; j < n; j++) {
                a[n * i + j] = arr[j];
            }
        }

        int f = 0;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            f = Math.max(f, 0) + a[i];
            ans = Math.max(ans, f);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum > 0 && k > 2){
            ans = Math.max(ans, sum * (k-2) + ans);
        }
        return ans % mod;
    }



    public int kConcatenationMaxSum_2(int[] arr, int k) {
        // 定义模数
        int mod = (int) (1e9 + 7);

        // 计算arr中最大子数组和的前两次拼接（通过arr * min(k, 2)）
        int n = arr.length;
        int[] a = new int[n * Math.min(k, 2)];

        for (int i = 0; i < Math.min(k, 2); i++) {
            for (int j = 0; j < n; j++) {
                a[i * n + j] = arr[j];
            }
        }

        // 使用Kadane算法计算最大子数组和
        int ans = 0;
        int f = 0;
        for (int i = 0; i < a.length; i++) {
            f = Math.max(0, f) + a[i];
            ans = Math.max(ans, f);
        }

        // 计算arr的总和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // 如果sum > 0 并且k > 2，考虑增加更多的拼接
        if (sum > 0 && k > 2) {
            ans = Math.max(ans, sum * (k - 2) + ans);
        }

        // 返回最终答案对mod取模的结果
        return ans % mod;
    }
}
