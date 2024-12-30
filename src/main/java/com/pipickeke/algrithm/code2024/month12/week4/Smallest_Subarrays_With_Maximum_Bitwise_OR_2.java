package com.pipickeke.algrithm.code2024.month12.week4;

import java.util.ArrayList;
import java.util.List;

public class Smallest_Subarrays_With_Maximum_Bitwise_OR_2 {

    private  int[] smallestSubarrays(int[] nums){

        int N = nums.length;
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] = 1;

            int x = nums[i];
            for (int j = i-1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                ans[j] = (nums[j] | x) > nums[j] ? i-j+1 : ans[j];
                nums[j] |= x;
            }
        }
        return ans;
    }


    private int[] smallestSubarrays_2(int[] nums){
        int N = nums.length;
        List<int[]> orlist = new ArrayList<int[]>();
        int[] ans = new int[N];
        for (int i = N-1; i >= 0; i--) {
            orlist.add(new int[]{0, i});
            int k=0;

            for (int[] item : orlist) {
                item[0] |= nums[i];
                if (orlist.get(k)[0] == item[0]){
                    orlist.get(k)[1] = item[1];
                } else {
                    orlist.set(++k, item);
                }
            }
            orlist.subList(k+1,orlist.size()).clear();
            ans[i] = orlist.get(0)[1] - i + 1;
        }
        return ans;
    }

}
