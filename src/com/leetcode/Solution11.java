package com.leetcode;

/**
 * @ 反转字符串
 */
public class Solution11 {

    public static void main(String args[]) {
        System.out.println(reverseString("12234"));
    }

    public static String reverseString(String s) {
        char[] a = s.toCharArray();
        char temp = '0';
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return new String(a);
    }
}
