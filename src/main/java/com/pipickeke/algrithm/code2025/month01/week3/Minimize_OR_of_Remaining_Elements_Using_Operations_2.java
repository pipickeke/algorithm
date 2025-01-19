package com.pipickeke.algrithm.code2025.month01.week3;

public class Minimize_OR_of_Remaining_Elements_Using_Operations_2 {


    public static void main(String[] args) {
        Minimize_OR_of_Remaining_Elements_Using_Operations_2 bean = new Minimize_OR_of_Remaining_Elements_Using_Operations_2();
        int[] nums = {3,5,3,2,7};
        int k = 2;
        for (int x : nums) {
            bean.printbit32(x);
        }
        System.out.println(bean.minOrAfterOperations(nums, k));
    }

    private void printbit32(int num){
        for (int i = 3; i >= 0; i--) {
            System.out.print( (num & (1 << i)) == 0 ? "0" : "1" );
        }
        System.out.println();
    }

    private int minOrAfterOperations(int[] nums, int k){
        int mask = 0;
        int ans = 0;
        for (int i = 29; i >= 0; i--) {
            mask |= (1 << i);
            int cnt = 0;
            int and = -1;
            for (int x : nums) {
                and &= x & mask;
                if (and != 0){
                    cnt++;
                } else {
                    and = -1;
                }
            }
            if (cnt > k){
                ans |= (1 << i);
                mask ^= (1 << i);
            }
        }
        return ans;
    }
}
