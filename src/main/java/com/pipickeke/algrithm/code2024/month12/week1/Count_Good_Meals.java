package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.HashMap;
import java.util.Map;


/**
 * 题目：大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i]
 * 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * 当前代码会超时！！！
 *
 */
public class Count_Good_Meals {

    public static void main(String[] args) {
        Count_Good_Meals bean = new Count_Good_Meals();
        int num = 2;
        int[] arr = {1,3,5,7,9};
//        System.out.println(bean.powOfTwo(num));
        System.out.println(bean.countPairs(arr));
    }

    private int countPairs(int[] deliciousness){
        int ans = 0;
        int mod = (int)1e9+7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int delici = deliciousness[i];
            for (Integer key : map.keySet()) {
                if (powOfTwo(key + delici)){
                    ans += map.get(key);
                }
            }
            map.put(delici, map.getOrDefault(delici,0)+1);

        }
        return (int) ans%mod;
    }

    private boolean powOfTwo(int num){
        return num > 0 && (num & (num-1)) == 0;
    }
}
