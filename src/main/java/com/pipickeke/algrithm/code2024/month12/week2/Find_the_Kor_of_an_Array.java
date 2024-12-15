package com.pipickeke.algrithm.code2024.month12.week2;

public class Find_the_Kor_of_an_Array {

    public static void main(String[] args) {
        Find_the_Kor_of_an_Array bean = new Find_the_Kor_of_an_Array();
        int[] arr = {7,12,9,8,9,15};
        int k = 4;
        System.out.println(bean.findKOr(arr, k));
    }

    private int findKOr(int[] nums, int k){
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int index = 0;
            while (cur != 0){
                bits[index] += (cur & 1);
                index++;
                cur >>=1;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] >= k){
                ans = (1 <<i) | ans;
            }
        }
        return ans;
    }
}
