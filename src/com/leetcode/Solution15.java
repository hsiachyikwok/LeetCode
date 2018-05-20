package com.leetcode;

/**
 * @ 验证回文字符串(忽略标点符号空格大小写只考虑字母和数字)
 */
public class Solution15 {
    public static void main(String args[]) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] a = s.toCharArray();
        //记录每次从后扫描用到的匹配回文的下标
        int index = a.length - 1;
        for (int i = 0; i < index; i++) {
            if (!isAlphabetOrNumber(a[i])) {
                continue;
            }
            for (int j = index; j > i; j--) {
                if (!isAlphabetOrNumber(a[j])) {
                    continue;
                }
                if (!isCharEquals(a[i], a[j])) {
                    return false;
                }
                index = j - 1;
                break;
            }
        }
        return true;
    }

    /**
     * 是否是数字或字母
     *
     * @param c
     * @return
     */
    private static boolean isAlphabetOrNumber(char c) {
        int charNum = (int) c;
        if (charNum >= 48 && charNum <= 57 || charNum >= 97 && charNum <= 122 || charNum >= 65 && charNum <= 90) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符是否相等 忽略大小写
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean isCharEquals(char a, char b) {
        int num1 = (int) a;
        int num2 = (int) b;
        if (num1 >= 48 && num1 <= 57 || num2 >= 48 && num2 <= 57) {
            if (num1 != num2) {
                return false;
            }
        }
        if (num1 == num2) {
            return true;
        } else if (num1 > num2) {
            if (num2 + 32 == num1) {
                return true;
            }
        } else {
            if (num1 + 32 == num2) {
                return true;
            }
        }
        return false;
    }
}
