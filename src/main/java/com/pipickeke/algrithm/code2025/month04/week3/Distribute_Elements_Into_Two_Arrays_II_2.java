package com.pipickeke.algrithm.code2025.month04.week3;

import java.util.ArrayList;
import java.util.Arrays;

public class Distribute_Elements_Into_Two_Arrays_II_2 {

    public int[] resultArray(int[] nums){
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int N = sorted.length;

        ArrayList<Integer> a = new ArrayList<> (N);
        ArrayList<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);

        Fenwick_2 f1 = new Fenwick_2(N + 1);
        Fenwick_2 f2 = new Fenwick_2(N + 1);
        f1.add(Arrays.binarySearch(sorted, nums[0]) +1);
        f2.add(Arrays.binarySearch(sorted, nums[1]) +1);

        for (int i = 2; i < N; i++) {
            int x = nums[i];
            int idx = Arrays.binarySearch(sorted, x) +1;
            int gc1 = a.size() - f1.pre(idx);
            int gc2 = b.size() - f2.pre(idx);
            if (gc1 > gc2 || gc1 == gc2 && a.size() <= b.size()){
                a.add(x);
                f1.add(idx);
            } else {
                b.add(x);
                f2.add(idx);
            }
        }

        a.addAll(b);
        for (int i = 0; i < N; i++) {
            nums[i] = a.get(i);
        }
        return nums;
    }

}

class Fenwick_2{

    int[] tree;

    public Fenwick_2(int n) {
        this.tree = new int[n];
    }

    public void add(int index){
        while (index < this.tree.length){
            this.tree[index]++;
            index += index&-index;
        }
    }

    public int pre(int index){
        int ans = 0;
        while (index > 0){
            ans += this.tree[index];
            index -= index&-index;
        }
        return ans;
    }
}




