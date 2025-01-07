package com.pipickeke.algrithm.code2025.month01.week1;

public class MaximumXORofTwoNumbersinanArray_2 {

    public static void main(String[] args) {
        MaximumXORofTwoNumbersinanArray_2 bean = new MaximumXORofTwoNumbersinanArray_2();
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
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

    private Trie root = null;
    private void add(int num){
        Trie cur = root;
        for (int i = 31; i >= 0; i--) {
            int k = (num >> i) &1;
            if (cur.son[k] == null){
                cur.son[k] = new Trie();
            }
            cur = cur.son[k];
        }
    }

    private int get(int num){
        Trie cur = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bitnum = (num >> i) &1;
            if (cur.son[bitnum ^ 1] != null){
                ans |= (1 << i);
                cur = cur.son[bitnum^1];
            } else {
//                ans |= (bitnum <<i);
                if (cur.son[bitnum] != null){
                    cur = cur.son[bitnum];
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    private class Trie{
        Trie[] son;

        public Trie() {
            son = new Trie[2];
        }
    }
}
