package com.leetcode;

/**
 * @ 买卖股票最佳时机2 可以多次买卖
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        int count = 0;
        int begin = 0;
        boolean flag = false;

        if (prices.length <= 1) {
            return 0;
        }
        while (true) {
            for (int i = begin; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    buy = i;
                    count++;
                } else {
                    if (count > 0) {
                        profit = profit + (prices[i] - prices[i - count]);
                        count = 0;
                        begin = i;
                        break;
                    }
                }
                if (i + 1 == prices.length - 1) {
                    flag = true;
                }
            }

            if (flag) {
                if (count == 0) {
                    return profit;
                } else {
                    profit = profit + (prices[prices.length - 1] - prices[buy - count + 1]);
                    return profit;
                }
            }
        }
    }
}
