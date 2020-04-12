package com.leet.day04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Number06 {

    /*
    2.1.6 最长连续序列
    定整数数组，找到最长的连续元素序列的长度。
    例如，给定[100，4，200，1，3，2]，最长连续元素序列为[1,2,3,4]。
    返回其长度：4.
    您的算法应该运行O（n）复杂度。
     */

    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        int s = longestConsecutive(arr);//暴力方法
        System.out.println(s);
        int s1 = longestConsecutive_sorted(arr);
        int s2 = longestConsecutive_hashing(arr);
    }

    public static int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    private static boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }

    public static int longestConsecutive_sorted(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }

    public static int longestConsecutive_hashing(int[] nums) {

        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
