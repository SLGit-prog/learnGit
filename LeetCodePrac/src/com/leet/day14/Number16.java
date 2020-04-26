package com.leet.day14;

import java.util.Arrays;

public class Number16 {
    /*
    2.1.16
    旋转图像 中等

    给定一个 n × n 的二维矩阵表示一个图像。
    将图像顺时针旋转 90 度。

    说明：
    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

    示例 1:
    给定 matrix =
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],

    原地旋转输入矩阵，使其变为:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]
     */
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
        rotate(image);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }

    }

    public static void rotate(int[][] matrix) {
        int len = matrix[0].length;
        int n = len - 1;
        int start = 0;
        while (n > 0) {
            System.out.println("n = " + n);
            for (int i = start; i < n; i++) {
                swap(matrix, start, i, i, n);
                swap(matrix, n - i + start, start, n, n - i + start);
                swap(matrix, start, i, n, n - i + start);
                for (int j = 0; j < matrix.length; j++) {
                    System.out.println(Arrays.toString(matrix[j]));
                }
                System.out.println("i = " + i);
                System.out.println("start = " + start);
                System.out.println();
            }
            n = n - 1;
            start = start + 1;
        }

    }

    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}
