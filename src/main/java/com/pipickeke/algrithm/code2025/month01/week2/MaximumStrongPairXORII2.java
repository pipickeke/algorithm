package com.pipickeke.algrithm.code2025.month01.week2;

import java.util.Arrays;


/**
 * 题目：2935. 找出强数对的最大异或值 II
 *
 * 给你一个下标从 0 开始的整数数组 nums 。如果一对整数 x 和 y 满足以下条件，则称其为 强数对 ：
 *
 * |x - y| <= min(x, y)
 * 你需要从 nums 中选出两个整数，且满足：这两个整数可以形成一个强数对，并且它们的按位异或（XOR）值是在该数组所有强数对中的 最大值 。
 *
 * 返回数组 nums 所有可能的强数对中的 最大 异或值。
 *
 * 注意，你可以选择同一个整数两次来形成一个强数对。
 *
 */

public class MaximumStrongPairXORII2 {

    public static void main(String[] args) {
        MaximumStrongPairXORII2 bean = new MaximumStrongPairXORII2();
        int[] nums = {1,2,3,4,5};
        System.out.println(bean.maximumStrongPairXor(nums));
    }


    private int maximumStrongPairXor(int[] nums){
        Arrays.sort(nums);
        root = new Trie();

        int left = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            add(x);
            while (nums[left]*2 < x){
                remove(nums[left++]);
            }
            ans = Math.max(ans, get(x));
        }
        return ans;
    }

    private void add(int num){
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >>i) &1;
            if (cur.son[bit] == null){
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.cnt++;
        }
    }

    private void remove(int num){
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) &1;
            cur = cur.son[bit];
            cur.cnt--;
        }
    }

    private int get(int num){
        Trie cur = root;
        int ans = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >>i) &1;
            if (cur.son[bit^1] != null && cur.son[bit^1].cnt > 0){
                ans |= (1 << i);
                bit ^= 1;
            }
            cur = cur.son[bit];
        }
        return ans;
    }

    private Trie root = null;
    private int HIGH_BIT = 19;
    private class Trie{
        Trie[] son = new Trie[2];
        int cnt;

        public Trie() {
            cnt = 0;
        }
    }
}
