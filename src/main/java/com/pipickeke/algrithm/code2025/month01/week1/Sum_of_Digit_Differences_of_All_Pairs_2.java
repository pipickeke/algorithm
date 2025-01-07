package com.pipickeke.algrithm.code2025.month01.week1;


/**
 * 题目：3153. 所有数对中数位差之和
 *
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 *
 * 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
 *
 * 请你返回 nums 中 所有 整数对里，数位差之和。
 *
 * 思路：
 *      可以从数字 nums[i] 的低位到高位，依次判断
 *      因为每位数字都是 [0,9] 共10个，可以为每个位维护一个 int[10]
 *      通过二维数组 matrix[N][10]实现
 *
 *      例如在判断个位的时候，
 *      当前枚举到  x=nums[k]，x的个位数是 mod = x%10
 *      则在此之前已经出现了 matrix[0][mod] 个 mod了，之前已经枚举的一共是 k 个数
 *      则在个位上面，就有  k-matrix[0][mod] 和 x 不同，则位差就此可以记录下来。
 *
 *      同样，在判断十位的时候
 *      就有  k-matrix[1][mod] 和 x 不同
 *
 */
public class Sum_of_Digit_Differences_of_All_Pairs_2 {


    private long sumDigitDifferences(int[] nums){

        long ans = 0;
        int[][] matrix = new int[Integer.toString(nums[0]).length()][10];
        for (int k = 0; k < nums.length; k++) {
            int x = nums[k];

            for (int i = 0; x > 0;x = x / 10, i++) {
                ans += k - matrix[i][x%10];
                matrix[i][x%10]++;
            }
        }
        return ans;
    }


    /**
     * 逆向思维， num[0]的十进制位数有 M，一共 N个数，则存在 M * N * (N-1) / 2个数对
     * 总的，减去每个进制位相同的个数，即可
     * @param nums
     * @return
     */
    private long sumDigitDifferences2(int[] nums){
        int N = nums.length;
        int M = Integer.toString(nums[0]).length();
        long ans = (long) M * N * (N-1)/2;
        int[][] matrix = new int[M][10];
        for (int k = 0; k < N; k++) {
            int x = nums[k];
            for (int i = 0; x > 0; x = x/10, i++) {
                ans -= matrix[i][x%10]++;
            }
        }
        return ans;
    }
}
