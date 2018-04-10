package com.leetcode;

/**
 * @ 长度为n的数组向右旋转k步
 */
public class Solution2 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = temp;
            k--;
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
