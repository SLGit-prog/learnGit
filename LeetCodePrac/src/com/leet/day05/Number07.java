package com.leet.day05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Number07 {
    /*
    2.1.7 Two Sum
    给定一个整数数组，找到两个数字，使它们加起来成为一个特定的目标数字。
    函数2 Sum应该返回两个数字的索引，以使它们加起来等于目标，其中index1必须小于index2。
    请注意，您返回的答案（index1和index2）都不基于零。
    您可以假设每个输入都只有一个解决方案。
    输入：数字= {2、7、11、15}，目标= 9输出：index1 = 1，index2 = 2
     */


    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 4)));
        System.out.println(Arrays.toString(twoSumDoubleHashing(arr, 4)));

    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1};
    }

    public static int[] twoSumDoubleHashing(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);    //这里虽然如果出现了重复的键,并且等于目标值的一半，但是他的索引是被后边的覆盖掉了
                                    //而数组是有序的，遍历时取到第一个元素的索引i，和map.get取到的索引肯定不相等
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[] {-1};
    }

    public static int[] twoSumHashTable(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
