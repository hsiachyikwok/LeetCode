package com.leetcode;

/**
 * @ 移动0，保持非零相对顺序
 */
public class Solution7 {

    public void moveZeroes(int[] nums) {
        int mark = -1;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && mark != -1) {
                nums[mark] = nums[i];
                nums[i] = 0;
                mark++;
            } else {
                if (flag && nums[i] == 0) {
                    mark = i;
                    flag = false;
                }
            }
        }
    }
}
