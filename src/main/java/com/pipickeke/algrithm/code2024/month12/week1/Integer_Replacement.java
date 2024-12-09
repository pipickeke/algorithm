package com.pipickeke.algrithm.code2024.month12.week1;

import java.util.HashMap;
import java.util.Map;







/**
 *  题目：整数替换
 *
 *  给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 返回 n 变为 1 所需的 最小替换次数 。
 */
public class Integer_Replacement {

    public static void main(String[] args) {
        Integer_Replacement bean = new Integer_Replacement();
        int n = 8;
        System.out.println(bean.integerReplacement(n));
    }

    private int integerReplacement(int n){
        if (n == Integer.MAX_VALUE){
            return 32;
        }
        return dfs(n, 0);
    }

    private int dfs(int n, int path){
        if (n == 1){
            return path;
        }
        if (n < 0){
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        int res1 = Integer.MAX_VALUE;
        int res2 = Integer.MAX_VALUE;

        if (n % 2 ==0){
            res = dfs(n>>1, path+1);
        } else {
            res1 = dfs(n+1, path+1);
            res2 = dfs(n-1, path+1);
        }
        return Math.min(res, Math.min(res1, res2));
    }

    private Map<Long, Integer> map = new HashMap<Long, Integer>();

    private int method(Long n){
        if (n == 1){
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = n % 2 == 0 ? method(n/2) : Math.min(method(n-1), method(n+1));
        map.put(n, ans+1);
        return map.get(n);
    }

    private int integerReplacement2(int n){
        return method(n*1L);
    }
}
