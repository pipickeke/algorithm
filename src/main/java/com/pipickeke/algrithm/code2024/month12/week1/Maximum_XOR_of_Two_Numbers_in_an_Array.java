package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.HashSet;
import java.util.Set;

public class Maximum_XOR_of_Two_Numbers_in_an_Array {

    public static void main(String[] args) {

    }

    private int findMaximumXOR(int[] nums){

        int ans = 0;
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int highBit = 31 - Integer.numberOfLeadingZeros(maxVal);
        int mask = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = highBit; i >= 0; i--) {

            set.clear();

            mask |= (1 << i);
            int newAns = ans | (1 <<i);

            for (int j = 0; j < nums.length; j++) {

                nums[j] = nums[j] & mask;

                if (set.contains(nums[j] ^ newAns)){
                    ans = newAns;
                    break;
                }
                set.add(nums[j]);
            }

        }
        return ans;
    }


    private int findMaximumXOR2(int[] nums){
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        // numberOfLeadingZeros 返回前导0的个数
        // 31 - numberOfLeadingZeros  则是计算最高位1所在位置
        int highBit = 31 - Integer.numberOfLeadingZeros(maxVal);
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int mask = 0;
        for (int i = highBit; i >= 0; i--) {

            set.clear();

            mask |= (1 <<i);
            int newAns = ans | (1 <<i);
            for (int j = 0; j < nums.length; j++) {

                int cur = nums[j];
                cur = cur & mask;
                if (set.contains(cur ^ newAns)){
                    ans = newAns;
                    break;
                }
                set.add(cur);
            }
        }
        return ans;
    }
}
