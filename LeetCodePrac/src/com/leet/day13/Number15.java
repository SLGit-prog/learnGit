package com.leet.day13;

public class Number15 {
    /*
    2.1.15
    接雨水 困难
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
    计算按此排列的柱子，下雨之后能接多少雨水。

    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，
    在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    示例:

    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6

     */
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int a = 0;
        int b = 0;
        int max = 0;

        // a 是数组的和，max是数组的最大值，b是最大值的索引
        for (int i = 0; i < height.length; i++) {
            a = a + height[i];
            if (max <= height[i]) {
                max = height[i];
                b = i;
            }
        }

        int c = 0;
        for (int i = 0; i < b; i++) {
            if (i == 0) {
                c = c + height[i];
                continue;
            }
            if (height[i] < height[i - 1]) {
                height[i] = height[i - 1];
            }
            c = c + height[i];

        }
        for (int i = height.length - 1; i >= b; i--) {
            if (i == height.length - 1) {
                c = c + height[i];
                continue;
            }
            if (height[i] < height[i + 1]) {
                height[i] = height[i + 1];

            }
            c = c + height[i];

        }
        return c - a;
    }
}
