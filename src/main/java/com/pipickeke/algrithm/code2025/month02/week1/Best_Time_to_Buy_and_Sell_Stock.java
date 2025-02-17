package com.pipickeke.algrithm.code2025.month02.week1;

/**
 * 题目：121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */

public class Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock bean = new Best_Time_to_Buy_and_Sell_Stock();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(bean.maxProfit(arr));
    }


    private int maxProfit(int[] prices){

        int N = prices.length;
        int minval = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, prices[i] - minval);
            minval = Math.min(minval, prices[i]);
        }

        return ans;
    }


}
