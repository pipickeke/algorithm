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
 * 思路：
 *  （1）超时的情况是遍历两次数组，时间复杂的是 O(n^2)
 *      可以转换思路，数组里面最大值 maxVal，则任意两个值最大和是 maxVal*2
 *      为了加快速度，同时满足两道菜的和是2的幂，
 *      可以从 1 开始，每次左移1位： x=1;x<=maxVal*2;x<<=1
 *      用 x 去逼近  maxVal*2。
 *      然后判断当前食品food，是否可以与其他菜品，和是maxVal，
 *      如果存在，  maxVal-food，则用哈希表记录下来，并记录当前两道菜的搭配
 *      如果不存在，则跳过
 *      用哈希表，可以记录的菜品，下次遍历到其他菜，直接判断哈希表中是否存在 x-food，
 *      取出记录数，累加即可。
 *      因为不同下标的菜品，任意组合都行
 *      [1,1,2] =>
 *          可以搭配出：(1,1)  (1,2)
 *                     (1,2)
 *
 *    是一种后置处理的思想，
 *    前面的遍历，会判断 maxVal*2-food，是否存在，如果不存在，则用哈希表保存当前food
 *    那么，在后面的遍历中，肯定会再次判断  maxVal*2-food，此时再去哈希表中拿，就有返回了
 *    返回了多少个，代表前面的food，可以和当前food，有多少种组合
 */
public class Count_Good_Meals_2 {

    public static void main(String[] args) {
        Count_Good_Meals_2 bean = new Count_Good_Meals_2();
        int[] food = {1,1,1,3,3,3,7};
        System.out.println(bean.countPairs(food));
    }

    private int countPairs(int[] deliciousness){
        int maxVal = 0;
        int mod = (int)1e9+7;
        for (int i = 0; i < deliciousness.length; i++) {
            maxVal = Math.max(maxVal, deliciousness[i]);
        }

        int maxSun = maxVal*2;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int food = deliciousness[i];

            for (int sum = 1; sum <= maxSun; sum <<= 1) {
                int cnt = map.getOrDefault(sum - food,0);
                ans = (ans + cnt) % mod;
            }
            map.put(food, map.getOrDefault(food,0)+1);
        }
        return ans;
    }


}
