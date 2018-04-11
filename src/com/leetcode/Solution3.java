package com.leetcode;

import java.util.HashSet;

/**
 * @ 是否包含重复数字
 */
public class Solution3 {
    //先快排再逐个比较
    public boolean containsDuplicate(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }

        }
        return false;
    }


    //快速排序(降序)
    private void quickSort(int left, int right, int[] nums) {
        int i = left;
        int j = right;
        int temp = 0;

        if (left < right) {

            temp = nums[i];
            while (i < right && temp < nums[i + 1]) {
                i++;
            }
            nums[left] = nums[i];

            while (j > left && temp > nums[j]) {
                j--;
            }
            nums[i] = nums[j];
            nums[j] = temp;
            quickSort(left, j - 1, nums);
            quickSort(i + 1, right, nums);
        }
    }

    //暴力破解
    public boolean containsDuplicate1(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j != i && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) { //使用HashSet

        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
