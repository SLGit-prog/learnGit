package com.leet.day17;

import java.util.ArrayList;
import java.util.List;

public class Number19DpGrayCode {
    /*
    2.1.19 格雷编码 中等

    格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
    给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
    示例 1:

    输入: 2
    输出: [0,1,3,2]
    解释:
    00 - 0
    01 - 1
    11 - 3
    10 - 2

    对于给定的 n，其格雷编码序列并不唯一。
    例如，[0,2,3,1] 也是一个有效的格雷编码序列。
    00 - 0
    10 - 2
    11 - 3
    01 - 1

    输入: 0
    输出: [0]
    解释: 我们定义格雷编码序列必须以 0 开头。
     给定编码总位数为 n 的格雷编码序列，其长度为 2的n次方。当 n = 0 时，长度为 2的0次方 = 1。
     因此，当 n = 0 时，其格雷编码序列为 [0]。
     */

    public static void main(String[] args) {
        System.out.println(grayCodeDif(3));
    }


    private static List<List<Integer>> records;

    /**
     * 返回num的greycode
     */
    private static List<Integer> dp(int num) {
        return records.get(num);
    }

    public static List<Integer> grayCodeDif(int n) {

        /*
        n = 1          n = 2            n = 3
          0  --  0   --  00  --  00  --  000
          1  --  1   --  01  --  01  --  001
             --  1   --  11  --  11  --  011
             --  0   --  10  --  10  --  010
                             --  10  --  110
                             --  11  --  111
                             --  01  --  101
                             --  00  --  100
         定义数字n的格雷编码为 dp[n], dp[n]中的范围为[0， 2^n], N为数字n的格雷编码的码长
         状态转移方程为
                    dp[n - 1][i]     (0 <= i < N/2)
         dp[n][i] =
                    dp[n][N - 1 - i] + (N/2 <= i < N)
         */
        records = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            records.add(new ArrayList<>(1 << i));
        }
        System.out.println(records);
        // 1. dp初始状态，即把数字0的格雷码先加入dp中
        dp(0).add(0);
        System.out.println(records);
        // 2. dp递推过程，通过循环依次计算数字1, 2, 3, ..., n 的格雷码
        for (int num = 1; num <= n; num++) {
            // 数字num的格雷码的总个数2^num
            int count = 1 << num;
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                int value;
                if (i < count / 2) {
                    // 前半部分直接复制num-1的格雷码
                    value = dp(num - 1).get(i);
                } else {
                    // 后半部分通过在首位添加1位1得到
                    int toAdd = 1 << (num - 1);
                    value = dp(num).get(count - 1 - i) + toAdd;
                }
                dp(num).add(value);
                System.out.println(records);
            }
        }
        return dp(n);
    }


    public static List<Integer> grayCode(int n) {
        /*
        优化后
         */

        /*
        n = 1          n = 2            n = 3
          0  --  0   --  00  --  00  --  000
          1  --  1   --  01  --  01  --  001
             --  1   --  11  --  11  --  011
             --  0   --  10  --  10  --  010
                             --  10  --  110
                             --  11  --  111
                             --  01  --  101
                             --  00  --  100
         定义数字n的格雷编码为 dp[n], dp[n]中的范围为[0， 2^n], N为数字n的格雷编码的码长
         状态转移方程为
                    dp[n - 1][i]     (0 <= i < N/2)
         dp[n][i] =
                    dp[n][N - 1 - i] + (N/2 <= i < N)
         */

        List<Integer> dp = new ArrayList<>(1 << n);
        dp.add(0);
        for (int num = 1; num <= n; num++) {
            int count = 1 << num;
            int toAdd = 1 << (num - 1);
            for (int i = count / 2; i < count; i++) {
                int value = dp.get(count - 1 - i) + toAdd;
                dp.add(value);
            }
        }
        return dp;
    }

}
