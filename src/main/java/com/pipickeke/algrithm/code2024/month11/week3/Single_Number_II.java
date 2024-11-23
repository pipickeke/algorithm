package com.pipickeke.algrithm.code2024.month11.week3;

import java.util.Arrays;

/**
 *  题目：只出现一次的数字 III
 *  给你一个整数数组 nums，其中恰好有两个元素只出现一次，
 *  其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 *
 *  思路：
 *  将全部数字做异或，相同的数字都被消除了，剩下的结果是恰好出现一次的两个元素a,b的异或值。
 *  cur = a^b
 *
 *  现在需要从cur，中分离出a，b
 *  可以先获取cur的最右侧的1,通过 low1 = cur&(-cur)，得到的是cur最右侧的1，形成的二进制值。
 *  利用这个值，可以把数组全部数字进行分类。
 *
 *  因为最后这个low1 是a 和 b 在该位置的异或结果，其他数字在该位置的异或结果，肯定都可以被清除
 *  所以再利用这个 low1，和数字每个数字 &
 *  结果=1, 属于 a
 *  结果=0，属于 b
 *  不断 异或 起来即可
 */
public class Single_Number_II {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(single(arr)));
    }

    private static int[] single(int[] nums){
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = cur ^ nums[i];
        }

        int low1 = cur == Integer.MIN_VALUE ? cur : (cur & (-cur));
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( (low1 & nums[i]) == 0){
                a = a ^ nums[i];
            } else {
                b = b ^ nums[i];
            }
        }
        return new int[]{a,b};
    }
}
