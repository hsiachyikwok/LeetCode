package com.leetcode;

import java.util.HashSet;

/**
 * @ 只出现一次的数字
 */
public class Solution4 {
    public int singleNumber(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }

        }
        return nums[nums.length - 1];
    }

    //快速排序
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

    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        for (int single : set) {
            result = single;
        }

        return result;
    }
}
