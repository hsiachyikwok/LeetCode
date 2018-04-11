package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ 两个数组的交集2
 */
public class Solution5 {

    public int[] intersect(int[] nums1, int[] nums2) { //超时

        quickSort(0, nums1.length - 1, nums1);
        quickSort(0, nums2.length - 1, nums2);
        ArrayList<Integer> arrayList = new ArrayList();
        int begin = 0;

        for (int j = 0; j < nums1.length; j++) {
            for (int i = begin; i < nums2.length; i++) {
                if (nums1[j] == nums2[i]) {
                    arrayList.add(nums1[j]);
                    begin = i + 1;
                    break;
                }
            }
        }

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
            System.out.println(array[i]);
        }
        return array;


    }

    //快速排序(升序)
    private void quickSort(int left, int right, int[] nums) {
        int i = left;
        int j = right;
        int temp = 0;

        if (left < right) {

            temp = nums[i];
            while (i < right && temp > nums[i + 1]) {
                i++;
            }
            nums[left] = nums[i];

            while (j > left && temp < nums[j]) {
                j--;
            }
            nums[i] = nums[j];
            nums[j] = temp;
            quickSort(left, j - 1, nums);
            quickSort(i + 1, right, nums);
        }
    }

    public int[] intersect1(int[] nums1, int[] nums2) { //通过
        ArrayList<Integer> arrayList = new ArrayList();
        HashSet<Integer> set = new HashSet();

        for (int j = 0; j < nums1.length; j++) {
            for (int i = 0; i < nums2.length; i++) {
                if ((!set.contains(i)) && nums1[j] == nums2[i]) {
                    set.add(i);
                    arrayList.add(nums1[j]);
                    break;
                }
            }
        }

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
            System.out.println(array[i]);
        }
        return array;
    }
}
