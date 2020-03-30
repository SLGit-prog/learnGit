package com.leet.day01;

import java.util.*;

public class Number2 {

    /*
       “删除重复项”的后续行动：
        如果最多允许重复两次，该怎么办？
        例如，给定sortedarrayA = [1,1,1,2,2,3]，
        您的函数应返回长度= 5，而Aisnow [1,1,2,2,3]
     */
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 2, 2, 3};
        int[] newArray = removeDuplicates(arr);
        System.out.println(Arrays.toString(newArray) + " " + newArray.length);

        int[] arrOther = new int[] {1, 1, 1, 2, 2, 3};
        int[] newArrayOther = removeDuplicatesOther(arrOther);
        System.out.println(Arrays.toString(newArrayOther) + " " + newArray.length);

    }

    public static int[] removeDuplicates(int[] arr) {
        if (arr.length <= 2) {
            return arr;
        }

        int index = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != arr[index - 2]) {
                arr[index++] = arr[i];
            }
        }

        return Arrays.copyOfRange(arr, 0, index);
    }

    public static int[] removeDuplicatesOther(int[] arr) {

        if (arr.length <= 2) {
            return arr;
        }
        int n = arr.length;
        int index = 0;

        for (int i = 0; i < n; ++i) {
            if (i < n -1 && i > 0 && arr[i - 1] == arr[i] && arr[i] == arr[i + 1]) {
                continue;
            }
            arr[index++] = arr[i];
        }

        return Arrays.copyOfRange(arr, 0, index);
    }

}

