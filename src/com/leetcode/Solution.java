package com.leetcode;

/**
 * @
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
        int count = 0; //总重复
        int begin = 0;
        int end = nums.length - 1;
        int mark = -1;
        while (true) {
            for (int i = begin; i < end; i++) {
                if (nums[i] == nums[i + 1]) {
                    duplicateCount++; //记录重复次数
                    mark = i; //记录最后相等的位置
                } else {
                    if (mark != -1) {
                        break;
                    }
                }
            }
            //退出条件
            if (mark == -1) {  //对应结尾没有重复
                break;
            }
            //删除重复
            if (duplicateCount > 0 && mark != -1) {
                for (int i = mark + 2, j = mark - duplicateCount + 2; i <= end; i++, j++) {
                    nums[j] = nums[i];
                }
            }
            count = count + duplicateCount;
            begin = mark - duplicateCount + 2;
            //退出条件
            if (begin < 0) { //begin < 0 对应结尾是重复
                break;
            }
            end = nums.length - count - 1;
            mark = -1;
            duplicateCount = 0;
        }
        for (int i = 0; i < nums.length - count; i++) {
            System.out.println(nums[i]);
        }
        return nums.length - count;
    }
}
