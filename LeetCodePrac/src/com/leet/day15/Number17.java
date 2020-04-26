package com.leet.day15;

import java.util.Arrays;

public class Number17 {
    /*
    2.1.17 加一 简单
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:
    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。
     */
    public static void main(String[] args) {
        int[] arr = new int[] {9, 9};
        System.out.println(Arrays.toString(plusOneElse(arr)));
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length; i >= 0 ; i--) {
            digits[i]++;
            if ((digits[i] = digits[i] % 10) != 0) return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOneElse(int[] digits) {
        /*
        自己乱作
        执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
        内存消耗 :37.8 MB, 在所有 Java 提交中击败了5.63%的用户
         */
        int lastIndex = digits.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (digits[i] + 1 <= 9) {
                digits[i] = digits[i] + 1;
                break;
            } else if( i == 0 && digits[i] == 9) {
                digits = new int[lastIndex + 2];
                digits[0] = 1;
            } else
                digits[i] = 0;
        }
        return digits;
    }
}
