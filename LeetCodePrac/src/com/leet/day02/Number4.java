package com.leet.day02;

public class Number4 {
    /*
        2.1.4 搜索旋转排序数组II
        题目：
            跟进“在旋转排序数组中搜索”：
            如果允许重复，该怎么办？ 这会影响运行时的复杂性吗？ 如何以及为什么？
            编写函数以确定给定目标是否在数组中。

        分析：
            允许重复元素，则上一题种如果A[m]>=A[l]，那么[l.m]为递增序列的假设就不能成立
            比如[1, 3, 1, 1 ,1]。
            如果A[m]>=A[l]不能确定递增，那么就把他拆分成两个条件：
            * 如果A[m]>A[l]，则区间[l,m]一定递增；
            * 如果A[m]==A[l], 不能确定，那久l++,往下看一步即可。
    */

    public static void main(String[] args) {
        int[] arr = new int[] {2,2,3,3,1,1,1,2}; // {2,2,3,3,1,1,1,2}
        int target = 3;
        boolean symbol = searchBinary(arr, target);
        System.out.println(symbol + "");
    }

    public static boolean searchBinary(int[] arr, int target) {

        int first = 0;
        int last = arr.length;

        while (first != last) {
            int mid = first + (last - first) / 2;

            if (arr[mid] == target) {
                return true;
            }
            if (arr[first] < arr[mid]) {
                if (arr[first] <= target && target < arr[mid]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else if (arr[first] > arr[mid]) {
                if (arr[mid] < target && target <= arr[last - 1]) {
                    first = mid + 1;
                } else {
                    last = mid;
                }
            } else {
                first++;
            }
        }
        return false;
    }
}
