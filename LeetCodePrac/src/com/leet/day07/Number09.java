package com.leet.day07;

import java.util.Arrays;

public class Number09 {
    /*
    2.1.9 最接近的三数之和

    给定一个包括n个整数的数组nums和一个目标值target。
    找出nums中的三个整数，使得它们的和与target最接近。
    返回这三个数的和。假定每组输入只存在唯一答案。
    例如，给定数组nums = [-1，2，1，-4], 和 target = 1.
    与target最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        int[] arr = new int[]{};
        System.out.println(threeSumClosest(arr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

}
