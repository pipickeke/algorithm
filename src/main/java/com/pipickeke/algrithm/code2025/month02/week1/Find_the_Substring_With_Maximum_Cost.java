package com.pipickeke.algrithm.code2025.month02.week1;

import java.util.Arrays;
import java.util.HashMap;

public class Find_the_Substring_With_Maximum_Cost {

    public static void main(String[] args) {
        Find_the_Substring_With_Maximum_Cost bean = new Find_the_Substring_With_Maximum_Cost();
        String s = "adaa";
        String chars = "d";
        int[] vals = {-1000};
        System.out.println(bean.maximumCostSubstring(s, chars, vals));
    }


    private int maximumCostSubstring(String s, String chars, int[] vals){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }

        int N = s.length();
        int[] arr = new int[N];
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            arr[i] = map.containsKey(x) ? map.get(x) : (x - 'a' + 1);
        }

        int presum = 0;
        int minval = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            presum += arr[i];
            ans = Math.max(ans, presum - minval);
            minval = Math.min(minval, presum);
        }
        return ans;
    }
}
