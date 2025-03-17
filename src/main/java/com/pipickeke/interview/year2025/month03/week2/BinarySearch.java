package com.pipickeke.interview.year2025.month03.week2;

/**
 *
 * 二分查找的多种写法:
 *
 */

public class BinarySearch {


    public static void main(String[] args) {
        BinarySearch bean = new BinarySearch();
        int[] arr = {1,2,4,5,5,7,9,20};
//        System.out.println(bean.binarySearch_1(arr, 5));
//        System.out.println(bean.binarySearch_2(arr, 5));
//        System.out.println(bean.binarySearch_3(arr, 5));
//        System.out.println(bean.binarySearch_4(arr, 5));
        System.out.println(bean.binarySearch_5(arr, 5));
    }

    /**
     * 经典迭代写法
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch_1(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right) >>> 1;
            if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    /**
     * 经典递归写法
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch_2(int[] nums, int target){
        return dfs(nums, 0, nums.length-1, target);
    }

    private int dfs(int[] nums, int left, int right, int target){
        if (left > right){
            return -1;
        }
        int mid = (left+right) >>> 1;
        if (nums[mid] == target){
            return mid;
        } else if (nums[mid] < target){
            return dfs(nums, mid+1, right, target);
        } else {
            return dfs(nums, left, mid-1, target);
        }
    }


    private int binarySearch_3(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left+right) >>> 1;
            if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }


    /**
     * 存在重复值，找到最左侧的左边
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch_4(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left+right) >>> 1;
            if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 存在重复值，找到最右侧坐标
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch_5(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left+right+1) >>> 1;
            if (nums[mid] <= target){
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
