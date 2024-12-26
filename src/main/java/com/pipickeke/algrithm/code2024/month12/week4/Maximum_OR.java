package com.pipickeke.algrithm.code2024.month12.week4;


/**
 * 题目：2680. 最大或值
 *
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。
 * 每一次操作中，你可以选择一个数并将它乘 2 。
 *
 * 你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。
 *
 * a | b 表示两个整数 a 和 b 的 按位或 运算。
 *
 * 思路：
 *  （1） 乘2，就是 <<1，想要最大，肯定是扩展结果的二进制位，最佳的就是只左移其中1个数
 *  （2） 那么就需要判断只 左移 <<k, 那个数字，需要枚举
 *  （3） 为了加速枚举，分别提前生成  左侧累或和  和 右侧累或和
 *               num[0],num[1],num[2],num[3].....,num[n-1]
 *   左侧累或和：left[0] = num[0]
 *              left[1] = num[0] | num[1]   =>   left[0] | num[1]
 *              left[2] = num[0] | num[1] | num[2]  => left[1] | num[2]
 *              ....
 *              left[n-1] = num[0] | .. | num[n-1]  => left[n-2] | num[n-1]
 *    右侧累或和：
 *              right[n] = num[n-1]
 *              right[n-1] = num[n-2] | num[n-1]
 *              right[n-2] = num[n-3] | num[n-2]
 *    右侧累或和可以提前生成。
 *    左侧在  枚举的过程同步生成  left |= num[i] 即可
 *
 */

public class Maximum_OR {

    public static void main(String[] args) {
        Maximum_OR bean = new Maximum_OR();
        bean.printBit(12);
        bean.printBit(9);
        bean.printBit(30);
        int[] nums = {12,9};
        int k = 1;
        System.out.println(bean.maximumOr(nums, k));
    }

    private long maximumOr(int[] nums, int k){

        long ans = 0;
        int N = nums.length;
        int[] rightor = new int[N+1];
        for (int i = N - 1; i >=0; i--) {
            rightor[i] = rightor[i+1] | nums[i];
        }

        for (int i = 0, left = 0; i < N; i++) {
            ans = Math.max(ans, left | ((long) nums[i] << k) | rightor[i+1]);
            left |= nums[i];
        }
        return ans;
    }

    private void printBit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1<<i)) == 0 ? "0" : "1" );
        }
        System.out.println();
    }
}
