package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.ArrayList;
import java.util.List;

public class Peaks_in_Array_3 {


    public List<Integer> countOfPeaks(int[] nums, int[][] queries){
        int N = nums.length;
        Fenwick_4 f = new Fenwick_4(N - 1);
        for (int i = 1; i < N - 1; i++) {
            update(f, nums, i, 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1){
                ans.add(f.query(q[1]+1, q[2]-1));
                continue;
            }
            int index = q[1];
            for (int j = Math.max(index-1,1); j <= Math.min(index+1, N-2); j++) {
                update(f, nums, j, -1);
            }
            nums[index] = q[2];
            for (int j = Math.max(index-1,1); j <= Math.min(index+1, N-2); j++) {
                update(f, nums, j, 1);
            }
        }
        return ans;
    }

    public void update(Fenwick_4 f, int[] nums, int index, int val){
        if (nums[index-1] < nums[index] && nums[index] > nums[index+1]){
            f.update(index, val);
        }
    }
}

class Fenwick_4{
    int[] tree;

    public Fenwick_4(int n) {
        this.tree = new int[n];
    }

    public void update(int index, int val){
        for (int i = index; i < this.tree.length; i += i&-i) {
            this.tree[i] += val;
        }
    }

    public int pre(int index){
        int ans = 0;
        for (int i = index; i > 0; i -= i&-i) {
            ans += this.tree[i];
        }
        return ans;
    }

    public int query(int left, int right){
        if (right < left){
            return 0;
        }
        return pre(right) - pre(left-1);
    }
}
