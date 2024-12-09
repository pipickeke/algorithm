package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.HashSet;


/**
 *  题目：数组中两个数的最大异或值
 *
 *  给你一个整数数组 nums ，返回 nums[i] XOR nums[j]
 *  的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 *  思路：
 *     如果是双层遍历，时间复杂度是 o^2，超时。
 *     可以尝试，判断最大的异或值，前导1占据多少位
 *     如：
 *     （1）先获取nums[]中最大值，maxVal，并获取该maxVal的最高位1所在位置 highBit
 *          可以得知，最大的异或值 xor，最高位可能就是 highBit,也可能不是。
 *      （2）开始从 [highBit,0] 开始尝试，并且增加掩码 mask |= (1 <<i)
 *          掩码用与截止每个遍历元素在该位置i，的符号是1还是0，
 *          尝试的是，xor 是否在i位置是1,  xor = ans | (1 <<i)  ans 是上一次位置i+1的判断结果
 *          如果xor在i位置是1，则存在两个值（a,b）   a^b 在 i 位置是1，那么肯定a,b 在i位置，
 *          肯定一个是0，一个是1   a^b=xor，那么  a(a^b)=a^xor =>  b = a^xor
 *          利用哈希表，判断 a^xor 是否存在，如果存在，则添加到结果ans中。
 *          后面继续逐位i判断
 *
 */
public class Maximum_XOR_of_Two_Numbers_in_an_Array_2 {

    public static void main(String[] args) {

    }

    private int findMaximumXOR(int[] nums){
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int highBit = 31 - Integer.numberOfLeadingZeros(maxVal);

        int mask = 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
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
