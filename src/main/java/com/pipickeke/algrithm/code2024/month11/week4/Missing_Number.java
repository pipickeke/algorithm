package com.pipickeke.algrithm.code2024.month11.week4;

public class Missing_Number {

    public static void main(String[] args) {
        Missing_Number bean = new Missing_Number();
        int[] arr = {3,0,1};
        System.out.println(bean.missingNumber(arr));
    }

    private int missingNumber(int[] nums){
        int xor = 0;
        int N = nums.length;
        for (int i = 1; i <= N; i++) {
            xor ^= i;
        }
        for (int i = 0; i < N; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
