package com.leet.day10;

import java.util.Arrays;

public class Number12 {
    /*
    2.1.12 下一个排列
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3

     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 7, 6};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void nextPermutation(int[] nums) {

        /*
        [1, 4, 2, 7, 6]
        找到数组末尾降序的排列，[i,j]
        然后取 i - 1，和 j。（其中j是降序排列的最小值，i-1是降序排列前的最近的值，
        并且，nums[i-1]是nums[i-1:j]中的最小值。)
        将他俩互换位置，则在降序排列的前最小的位上变大了最小的程度，如题是在百位上。
        而后将[i,j]进行反转。使得十位和个位进行反转，变成递增序列。
        则在百位不变的情况，即量级不变，数值变小。即下一个序列
         */

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
