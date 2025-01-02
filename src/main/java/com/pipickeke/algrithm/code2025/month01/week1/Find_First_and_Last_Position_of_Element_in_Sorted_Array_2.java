package com.pipickeke.algrithm.code2025.month01.week1;

/**
 * 题目：34. 在排序数组中查找元素的第一个和最后一个位置
 * 标签：二分查找
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 */

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_2 {

    private int[] searchRange(int[] nums, int target){
        int start = lowbound(nums, target);
        if (start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        int end = lowbound(nums, target+1)-1;
        return new int[]{start,end};
    }

    /**
     * 左闭右开区间写法
     * @param nums
     * @param target
     * @return
     */
    private int lowbound(int[] nums, int target){
        int left = 0;
        int right = nums.length; //左闭右开区间，[left,right)
        while (left < right){
            //循环不变量
            // num[left-1] < target
            // num[right] >= target
            int mid = left + (right-left)/2;
            if (nums[mid] >= target){
                right = mid; //左闭右开区间，[left, mid)
            } else {
                left = mid+1; //左闭右开区间, [mid+1, right)
            }
        }
        return left;
    }

    /**
     * 同样是左闭右开区间，如果先判断 num[mid] < target，则 left = mid, else: right = mid-1
     * 因为取 mid 的时候，整数相加/2，是向下取整。 如果判断  num[mid] <= target, left = mid，则可能错过target
     * @param nums
     * @param target
     * @return
     */
    private int lowbound2(int[] nums, int target){
        int left = 0;
        int right = nums.length; //左闭右开区间，[left,right)
        while (left < right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
