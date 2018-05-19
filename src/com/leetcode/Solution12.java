package com.leetcode;

/**
 * @ 颠倒整数
 * -2147483648 int MIN_VALUE
 *  2147483647 int MAX_VALUE
 */
public class Solution12 {

    public static void main(String args[]) {
        System.out.println(reverse(120));
    }

        public static int  reverse(int x) {
            if (x == 0 || x == Integer.MIN_VALUE) {
                return 0;
            }

            boolean mark = false;
            int temp = 1000000000;
            int sum = 0;
            /**
             * 将负数转化为正数处理
             */
            if (x < 0) {
                x = -x;
                mark = true;
            }
            /**
             * 将类似12000结尾的0去除
             */
            while(x % 10 == 0 ){
                x = x / 10;
            }

            while (x / temp == 0) {
                temp = temp / 10;
            }
            while (x >= 10) {
                int value = (x % 10) * temp;
                sum = sum + value;
                if(sum < 0 || sum < temp) {
                    return 0;
                }
                x = x / 10;
                temp = temp / 10;
            }
            sum = sum + x;
            if (mark) {
                sum = -sum;
            }
            return sum;
        }
    }

