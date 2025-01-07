package com.pipickeke.algrithm.code2025.month01.week1;

public class Sum_of_All_Subset_XOR_Totals_2 {


    private int subsetXORSum(int[] nums){
        ans = 0;
        dfs(0,0,nums);
        return ans;
    }

    private int ans;
    private void dfs(int index, int xor, int[] nums){
        if (index == nums.length){
            ans += xor;
            return;
        }
        dfs(index+1, xor, nums);
        dfs(index+1, xor ^ nums[index], nums);
    }
}
