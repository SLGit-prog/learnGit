package com.leet.day03;

public class Number05 {

    /*
    2.1.5 两个排列数组的中位数****待补充
    题目：
        分别有大小为m和n的两个排序数组A和B。
        找到两个排序数组的中位数。
        整个运行时复杂度应为O（log（m + n））。
    分析：
        给定两个已经排序好的数组，找到两个所有元素中第k大的元素
        O(m+n)的解法比较直观，直接merge两个数组，然后求解第k大的元素
        不过只需要获取中位数，是不应该进行排序复杂度这么高的操作的。

        如果能够每次都删除一个一定在K之前的元素，那么只需要进行k次 即（m+n)/2次
        那么假设A和B的元素个数都大于 k/2，
        我们将 A 的第 k/2 个元素即 A[k/2-1] 和 B 的第 k/2 个元素即 B[k/2-1] 进行比较
        有三种情况
        * A[k/2-1] == B[k/2-1]
        * A[k/2-1] > B[k/2-1]
        * A[k/2-1] < B[k/2-1]

        如果 A[k/2-1] < B[k/2-1]，
        那么A[0] 到 A[k/2-1]肯定在A∪B的topk范围内，
        A[k/2-1] 不可能大于A∪B的第k大元素

        因此，我们可以放心的删除A数组的这个k/2个元素。
        同理，当A[k/2-1] > B[k/2-1]时候，可以删除B数组的k/2个元素
        当A[k/2-1] = B[k/2-1]时，说明找到了第k大的元素，直接返回A[k/2-1]或者B[k/2-1]即可

        因此，可以写一个递归函数。终止条件是：
        * 当 A 或者 B 是空时候，直接返回 B[k-1] 或者A [k-1]
        * 当 k=1 时候，返回min(A[0], B[0]);
        * 当 A[k/2-1] == B[k/2-1] 时候，返回 A[k/2-1] 或者 B[k/2-1]
     */

    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 2, 3, 5, 7};
        int[] arrayB = new int[]{3, 5, 7, 9, 12, 66};
        System.out.println(findMedianSortedArraysMerged(arrayA, arrayB));
        System.out.println(findMedianSortedArraysPointer(arrayA, arrayB));

    }

    public static double findMedianSortedArraysMerged(int nums1[], int nums2[]) {
        /*
        合并两个数组，排序暴力求解
        时间复杂度 O(m + n)
        空间复杂度 O(n + n)
         */
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[n + m];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[n / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];

            } else {
                nums[count++] = nums2[j++];
            }

            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    public static double findMedianSortedArraysPointer(int[] A, int[] B) {
        /*
        时间复杂度：遍历len/2+1 次，O(m + n)
        空间复杂度：8个变量，O(1)
         */

        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1;
        int right = -1;
        int aStart = 0, bStarit = 0;

        for (int i = 0; i <= len / 2; i++) {
            left = right;

            if (aStart < m && (bStarit >= n || A[aStart] < B[bStarit])){
                right = A[aStart++];
            } else {
                right = B[bStarit++];
            }
        }

        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }

    }

}
