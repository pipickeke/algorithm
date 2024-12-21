package com.pipickeke.algrithm.code2024.month12.week3;

public class CountPairsWithXORinaRange_2 {


    private int countPairs(int[] nums, int low, int high){
        return func(nums, high) - func(nums, low-1);
    }

    private final int HIGH_BIT = 14;
    private Trie root = null;

    private int func(int[] nums, int x){
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i-1]);
            res += get(nums[i], x);
        }
        return res;
    }

    private void add(int num){
        Trie cur = root;

        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) &1;
            if (cur.son[bit] == null){
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    private int get(int num, int x){
        Trie cur = root;

        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >>k) &1;
            int xBit = (x >> k) &1;
            if (xBit != 0){
                if (cur.son[bit] != null){
                    sum += cur.son[bit].sum;
                }
                if (cur.son[bit ^ 1] == null){
                    return sum;
                }
                cur = cur.son[bit ^ 1];
            } else {
                if (cur.son[bit] == null){
                    return sum;
                }
                cur = cur.son[bit];
            }
        }
        sum += cur.sum;
        return sum;
    }

    private class Trie{
        Trie[] son = new Trie[2];
        int sum;

        public Trie() {
            sum = 0;
        }
    }
}
