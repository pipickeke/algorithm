package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：3072. 将元素分配到两个数组中 II
 *
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 *
 * 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
 *
 * 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 *
 * 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
 * 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
 * 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
 * 如果仍然相等，那么将 nums[i] 追加到 arr1 。
 * 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 *
 * 返回整数数组 result 。
 *
 */

public class Distribute_Elements_Into_Two_Arrays_II {

    public int[] resultArray(int[] nums){
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int N = sorted.length;

        ArrayList<Integer> a = new ArrayList<>(N);
        ArrayList<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);

        Fenwick f1 = new Fenwick(N + 1);
        Fenwick f2 = new Fenwick(N + 1);
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

class Fenwick{
    int[] tree;

    public Fenwick(int n) {
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
