package com.leetcode;

import java.util.HashMap;

/**
 * @ 有效的字母异位词
 * 暴力解法和排序后比较算法不考虑，时间复杂度较高
 */
public class Solution14 {

    public static void main(String args[]) {
        System.out.println(isAnagram("aac", "aca"));
    }

    public static boolean isAnagram1(String s, String t) {
        HashMap<String, Integer> map = new HashMap();
        map.put("a", 2);
        map.put("b", 3);
        map.put("c", 5);
        map.put("d", 7);
        map.put("e", 11);
        map.put("f", 13);
        map.put("g", 17);
        map.put("h", 19);
        map.put("i", 23);
        map.put("j", 29);
        map.put("k", 31);
        map.put("l", 37);
        map.put("m", 41);
        map.put("n", 43);
        map.put("o", 47);
        map.put("p", 53);
        map.put("q", 59);
        map.put("r", 61);
        map.put("s", 67);
        map.put("t", 71);
        map.put("u", 73);
        map.put("v", 79);
        map.put("w", 83);
        map.put("x", 89);
        map.put("y", 91);
        map.put("z", 97);
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        long result1 = getSignature(a, map);
        long result2 = getSignature(b, map);
        if (a.length != b.length) {
            return false;
        }
        if (result1 == result2) {
            return true;
        } else {
            return false;
        }
    }

    //计算签名，当字符串很长计算值超过所能表达的数值时。结果不准确
    private static Long getSignature(char[] chars, HashMap<String, Integer> map) {
        long sum = 1;
        for (char a : chars) {
            sum = sum * map.get(String.valueOf(a));
        }
        return sum;
    }

    //对每个字母采取计数
    public static boolean isAnagram(String s, String t) {
        HashMap<String, Integer> map = new HashMap();
        if (s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            String value = String.valueOf(s.charAt(i));
            Integer integer = map.get(value);
            if(integer == null) {
                map.put(value,1);
            }else{
                map.put(value,map.get(value)+1);
            }

            value = String.valueOf(t.charAt(i));
            integer = map.get(value);
            if(integer == null) {
                map.put(value,-1);
            }else {
                map.put(value,map.get(value)-1);
            }
        }

        for(Integer integer:map.values()) {
         if(integer != 0){
             return false;
         }
        }
        return true;
    }
}
