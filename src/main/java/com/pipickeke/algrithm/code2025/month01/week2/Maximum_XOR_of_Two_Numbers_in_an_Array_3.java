package com.pipickeke.algrithm.code2025.month01.week2;

public class Maximum_XOR_of_Two_Numbers_in_an_Array_3 {

    public static void main(String[] args) {
        Maximum_XOR_of_Two_Numbers_in_an_Array_3 bean = new Maximum_XOR_of_Two_Numbers_in_an_Array_3();
        int[] nums = {3,10,5,25,2,8};
        System.out.println(bean.findMaximumXOR(nums));
    }

    private int findMaximumXOR(int[] nums){
        root = new Trie();
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i-1]);
            ans = Math.max(ans, get(nums[i]));
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
        }
    }

    private int get(int num){
        Trie cur = root;
        int ans = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >>i) &1;
            if (cur.son[bit ^ 1] != null){
                ans |= (1 << i);
                cur = cur.son[bit ^ 1];
            } else {
                if (cur.son[bit] == null){
                    return ans;
                } else {
                    cur = cur.son[bit];
                }
            }
        }
        return ans;
    }

    private Trie root = null;
    private static final int HIGH_BIT = 19;
    private class Trie{
        Trie[] son = new Trie[2];

        public Trie() {
        }
    }
}
