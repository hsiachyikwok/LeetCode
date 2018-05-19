package com.leetcode;

/**
 * @ 字符串中的第一个唯一字符
 */
public class Solution13 {
    public static void main(String args[]) {
        System.out.println(firstUniqChar("aadadaad"));//aadadaad dddccdbba
    }

    public static int firstUniqChar(String s) {
        char[] a = s.toCharArray();
        if(a.length == 1) {
            return 0;
        }
        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j < a.length; j++){
                if(j == i) {
                    continue;
                }
                if(a[i] == a[j]) {
                    break;
                }else
                    if(j == a.length-1||(i == a.length-1&&j == a.length - 2)){
                    return i;
                }
            }
        }
        return -1;
    }
}
