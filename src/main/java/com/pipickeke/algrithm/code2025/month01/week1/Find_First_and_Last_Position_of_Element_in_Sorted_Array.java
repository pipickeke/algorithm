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
 */
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    private int[] searchRange(int[] nums, int target){
        int start = lowbound(nums, target);
        if (start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        int end = lowbound(nums, target+1)-1;
        return new int[]{start,end};
    }

    /**
     * 闭区间写法，即 while 条件是 left <= right
     * @param nums
     * @param target
     * @return
     */
    private int lowbound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            //循环不变量
            // num[left-1] < target
            // num[right+1] >= target
            int mid = left + (right-left)/2;
            if (nums[mid] >= target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        //while 循环结束时， left = right+1
        //nums[] 是非递增的，
        //此时：
        //nums[left-1] < target
        //nums[left] = nums[right+1] >= target
        // left 就是 第一个 >= target 的下标
        return left;
    }


    /**
     * 同样是闭区间，因为mid的取值是  边界之和/2，向下取整，mid 是偏左的。
     * 如果要先判断  num[left] < target，则 left = mid+1, else: right = mid-1
     * 不能换成判断，  num[left] <= target,  那样会错误target
     * @param nums
     * @param target
     * @return
     */
    private int lowbound2(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;   //闭区间 [left,right]
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        //while 循环结束时， left = right+1
        //nums[] 是非递增的，
        //此时：
        //nums[left-1] < target
        //nums[left] = nums[right+1] >= target
        // left 就是 第一个 >= target 的下标
        return left;
    }

}
