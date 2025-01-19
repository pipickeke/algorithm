package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 题目：2354. 优质数对的数目
 * 标签：恒等式
 *
 * 给你一个下标从 0 开始的正整数数组 nums 和一个正整数 k 。
 *
 * 如果满足下述条件，则数对 (num1, num2) 是 优质数对 ：
 *
 * num1 和 num2 都 在数组 nums 中存在。
 * num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和大于等于 k ，其中 OR 是按位 或 操作，而 AND 是按位 与 操作。
 * 返回 不同 优质数对的数目。
 *
 * 如果 a != c 或者 b != d ，则认为 (a, b) 和 (c, d) 是不同的两个数对。例如，(1, 2) 和 (2, 1) 不同。
 *
 * 注意：如果 num1 在数组中至少出现 一次 ，则满足 num1 == num2 的数对 (num1, num2) 也可以是优质数对。
 *
 *
 */

public class Number_of_Excellent_Pairs {


    private long countExcellentPairs(int[] nums, int k){
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (set.add(x)){
                int cnt = Integer.bitCount(x);
                map.put(cnt, map.getOrDefault(cnt,0)+1);
            }
        }
        long ans = 0;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            for (Map.Entry<Integer, Integer> y : map.entrySet()) {
                if (x.getKey() + y.getKey() >= k){
                    ans += (long) x.getValue() * y.getValue();
                }
            }
        }
        return ans;
    }
}
