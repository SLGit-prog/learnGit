package com.leet.day02;

public class Number3 {
    /*
    2.1.3  搜索旋转排序数组
    题目：
        假设已排序的数组以您不知道的某个轴旋转。
         （即0 1 2 4 5 6 7可能会变成4 5 6 7 0 1 2）。
         将为您提供要搜索的目标值。 如果在数组中找到，则返回其索引，否则返回-1。
         您可以假定数组中不存在重复项。

    分析：
        二分查找，难度主要在于左右边界的确定。

    自我总结：
        二分查找只能对有序数组有效，所以优先划定范围再有序的区域内
        即判断 (arr[first] <= arr[mid]) | (arr[mid] <= arr[last])  //找到有序边界范围
        进而判断 (arr[first] <= target && target <= arr[mid]) | (arr[mid] <= target && target <= arr[last])
        //二分法查找

        另有一个疑问：如果target并未在选定的有序范围内，怎么办？
        答：在第一个有序范围内进行判断，target并不介于有序范围的上下界之间
        自然就会跳出这个有序范围。

     */
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        int targetIndex = search(arr, target);
        System.out.println(targetIndex);
    }

    public static int search(int[] arr, int target) {
        int first = 0;
        int last = arr.length;

        while (first != last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[first] <= arr[mid]) {
                if (arr[first] <= target && target < arr[mid]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[last-1]) {
                    first = mid + 1;
                } else {
                    last = mid;
                }
            }
        }
        return -1;
    }

}
