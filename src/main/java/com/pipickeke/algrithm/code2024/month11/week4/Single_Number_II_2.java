package com.pipickeke.algrithm.code2024.month11.week4;

public class Single_Number_II_2 {

    public static void main(String[] args) {

    }

    private int singleNumber(int[] nums){

        int ans = 0;
        for (int i = 0; i < 32; i++) {

            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >>i) &1;
            }
            sum %= 3;
            if (sum != 0){

            }
            ans |= (sum <<i);
        }
        return ans;
    }
}
