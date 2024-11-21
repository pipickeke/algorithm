package com.pipickeke.algrithm.code2024.month11;

import java.util.Arrays;
import java.util.Random;

/**
 * 唯一成对数
 * 题目：
 * 1 ~ 1000 放在含有1001个元素的数组中，只有唯一的一个元素重复，
 * 其他元素均只出现一次，每个数组元素只能访问一次，不能使用辅助空间，
 * 找出重复的数
 *
 * 思路：
 * 利用位运算 异或
 * A ^ A = 0
 * A ^ 0 = A
 *
 * 设置初始值 code=0
 * 1~1000 可以利用数组循环异或，
 * 然后将得出的结果在去异或数组的每个元素，
 * 最终剩余的值就是重复的那个数
 */
public class Unique_Logarithmic_Number {

    public static void main(String[] args) {
        int len = 1001;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i+1;
        }
        int random = new Random().nextInt(len-1) + 1;
        arr[len-1] = random;

        System.out.println(Arrays.toString(arr));

        int code = 0;
        for (int i = 1; i < 11; i++) {
            code = code ^ i;
        }
        for (int i = 0; i < len; i++) {
            code = code ^ arr[i];
        }
        System.out.println(code);
    }
}
