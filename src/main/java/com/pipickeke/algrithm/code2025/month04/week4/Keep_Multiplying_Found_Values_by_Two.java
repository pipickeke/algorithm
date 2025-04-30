package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.Arrays;

/**
 * 题目：2154. 将找到的值乘以 2
 *
 * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
 *
 * 接下来，你需要按下述步骤操作：
 *
 * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
 * 否则，停止这一过程。
 * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
 * 返回 original 的 最终 值。
 *
 */

public class Keep_Multiplying_Found_Values_by_Two {

    public static void main(String[] args) {
        int[] nums = {5,3,6,1,12};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.binarySearch(nums, 4));
    }


    public int findFinalValue(int[] nums, int original){

        Arrays.sort(nums);

        int index = Arrays.binarySearch(nums, original);
        while (index > -1){
            original *= 2;
            index = Arrays.binarySearch(nums, original);
        }
        return original;
    }
}
