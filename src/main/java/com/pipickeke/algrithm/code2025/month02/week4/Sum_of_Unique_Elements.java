package com.pipickeke.algrithm.code2025.month02.week4;

import java.util.HashMap;
import java.util.Map;

public class Sum_of_Unique_Elements {

    public static void main(String[] args) {
        Sum_of_Unique_Elements bean = new Sum_of_Unique_Elements();
        int[] nums = {1,2,3,2};
        System.out.println(bean.sumOfUnique(nums));
    }


    private int sumOfUnique(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += entry.getValue() == 1 ? entry.getKey() : 0;
        }
        return ans;
    }

}
