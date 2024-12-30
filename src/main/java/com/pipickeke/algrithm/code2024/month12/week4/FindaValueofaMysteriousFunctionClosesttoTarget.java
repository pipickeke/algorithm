package com.pipickeke.algrithm.code2024.month12.week4;

/**
 * 题目：1521. 找到最接近目标值的函数值
 * 标签：Logtrick，子数组
 *
 * Winston 构造了一个如上所示的函数 func 。他有一个整数数组 arr 和一个整数 target ，他想找到让 |func(arr, l, r) - target| 最小的 l 和 r 。
 *
 * 请你返回 |func(arr, l, r) - target| 的最小值。
 *
 * 请注意， func 的输入参数 l 和 r 需要满足 0 <= l, r < arr.length 。
 *
 *
 *  思路：
 *  i=1 时，我们会把 arr[0] 到 arr[1] 的 AND 记录在 arr[0] 中
 *  i=2 时，我们会把 arr[1] 到 arr[2] 的 AND 记录在 arr[1] 中，arr[0] 到 arr[2] 的 AND 记录在 arr[0] 中。
 * i=3 时，我们会把 arr[2] 到 arr[3] 的 AND 记录在 arr[2] 中；arr[1] 到 arr[3] 的 AND 记录在 arr[1] 中；arr[0] 到 arr[3] 的 AND 记录在 arr[0] 中。
 *
 * 对于两个二进制数 a 和 b，如果 a&b=a，从集合的角度上看，
 * a 对应的集合是 b 对应的集合的子集。或者说，b 对应的集合是 a 对应的集合的超集
 *
 */

public class FindaValueofaMysteriousFunctionClosesttoTarget {


    private int closestToTarget(int[] arr, int target){

        int N = arr.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int x = arr[i];

            diff = Math.min(diff, Math.abs(x - target));

            for (int j = i-1; j >= 0 && (arr[j] & x) != arr[j]; j--) {
                arr[j] &= x;
                diff = Math.min(diff, Math.abs(arr[j] - target));
            }
        }
        return diff;
    }
}
