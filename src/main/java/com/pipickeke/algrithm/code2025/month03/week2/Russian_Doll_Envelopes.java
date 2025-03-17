package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.*;
import java.util.stream.Stream;

/**
 * 题目：354. 俄罗斯套娃信封问题
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 *
 */

public class Russian_Doll_Envelopes {

    public static void main(String[] args) {
        Russian_Doll_Envelopes bean = new Russian_Doll_Envelopes();
        int[][] matrix = {{5,4}, {6,4}, {6,7}, {2,3}};
        System.out.println(bean.maxEnvelopes(matrix));
    }


    private int maxEnvelopes(int[][] envelopes){
        ArrayList<Env> list = new ArrayList<>();
        for (int[] row : envelopes) {
            list.add(new Env(row[0], row[1]));
        }

        Collections.sort(list, new Comparator<Env>() {
            @Override
            public int compare(Env o1, Env o2) {
                return o1.wide != o2.wide ? o1.wide - o2.wide : o2.high - o1.high;
            }
        });
        int n = list.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Env env = list.get(i);
            int j = lowbound(ans, env.high);
            if (j == ans.size()){
                ans.add(env.high);
            } else {
                ans.set(j, env.high);
            }
        }
        return ans.size();
    }

    private int lowbound(List<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (list.get(mid) < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    private class Env{
        int wide;
        int high;

        public Env() {
        }

        public Env(int wide, int high) {
            this.wide = wide;
            this.high = high;
        }

        public int getWide() {
            return wide;
        }

        public void setWide(int wide) {
            this.wide = wide;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        @Override
        public String toString() {
            return "Env{" +
                    "wide=" + wide +
                    ", high=" + high +
                    '}';
        }
    }
}
