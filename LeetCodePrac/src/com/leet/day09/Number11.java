package com.leet.day09;

import java.util.Arrays;

public class Number11 {
    /*
    移除元素  //简单
    给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int val = 3;
        System.out.println(removeElement(arr, val));
        System.out.println(removeElementTwoPointers(arr, val));
    }

    private static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    private static int removeElementTwoPointers(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
