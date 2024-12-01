package com.pipickeke.algrithm.code2024.month12.week1;


/**
 *  题目：汉明距离总和
 *
 *  两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。
 *
 *  思路：
 *      如果分别两两计算汉明距离，会超时。
 *      转换思路，从低位，到高31位，每个位置上，有多少元素nums[i] 在该位置上是1,
 *      有多少元素在该位置上是0，那么该位置上的汉明距离就是   n * (num.length - n)
 *
 */
public class Total_Hamming_Distance {

    public static void main(String[] args) {
        Total_Hamming_Distance bean = new Total_Hamming_Distance();
        int[] arr = {4,14,2};
        System.out.println(bean.totalHammingDistance(arr));
    }

    private int totalHammingDistance(int[] nums){

        int ans = 0;
        for (int i = 0; i < 30; i++) {
            int curSum = 0;
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                tmp >>>=i;
                curSum += (tmp &1);
            }
            ans += curSum * (nums.length - curSum);
        }
        return ans;
    }

    private int hanming(int x, int y){
        int xor = x ^ y;
        int cnt = 0;
        while ( xor != 0 ){
            cnt += ((xor &1) == 0 ? 0 : 1);
            xor >>>=1;
        }
        return cnt;
    }
}
