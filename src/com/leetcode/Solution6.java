package com.leetcode;

/**
 * @ 非负整数加一
 */
public class Solution6 {
    public int[] plusOne(int[] digits) {
        int mark = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i] = digits[i] + 1;
            } else {
                digits[i] = digits[i] + mark;
                mark = 0;
            }
            if (digits[i] > 9) {
                digits[i] = 0;
                mark = 1;
                if (i == 0) {
                    int [] ndigits = new int[digits.length+1];
                    ndigits[0] = 1;
                    return ndigits;
                }
            }
        }
        return digits;
    }
}
