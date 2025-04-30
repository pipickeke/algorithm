package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.Collections;
import java.util.Date;
import java.util.PriorityQueue;

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
