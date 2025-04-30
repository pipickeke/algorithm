package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.Collections;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * 题目：2208. 将数组和减半的最少操作次数
 * 给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 *
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
 *
 */

public class Minimum_Operations_to_Halve_Array_Sum {


    public static void main(String[] args) {
        int[] nums = {5,19,8,1};
        Minimum_Operations_to_Halve_Array_Sum bean = new Minimum_Operations_to_Halve_Array_Sum();
        System.out.println(bean.halveArray(nums));
    }


    public int halveArray(int[] nums){

        PriorityQueue<Double> heap = new PriorityQueue<>(Collections.reverseOrder());
        double totalSum = 0;
        for (int x : nums) {
            double val = (double) x;
            totalSum += val;
            heap.offer(val);
        }

        double halfSum = totalSum/2;
        double curSum = totalSum;
        int opr = 0;
        while (curSum > halfSum){
            double max = heap.poll();
            double half = max / 2;
            curSum -= half;
            heap.offer(half);
            opr++;
        }
        return opr;
    }
}
