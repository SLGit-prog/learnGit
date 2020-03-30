package com.leet.day01;

import java.util.*;

public class Number1 {
    /*
     给定一个已排序的数组，将重复项删除就位，以使每个元素仅出现一次并返回新的长度。
     不要为另一个数组分配额外的空间，必须使用恒定的内存来就位。
     例如，给定输入数组A = [1,1,2]，
     您的函数应该返回长度= 2，并且A现在为[1,2]。
    */

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3};
        Scanner sc = new Scanner(System.in);
        String met = sc.nextLine();
        if ("1".equals(met)) {
            HashSet<Integer> hs = getHsMap(array);   //ctrl + alt + m 抽取方法快捷键；
            System.out.println(hs + " " + hs.size());         //hs有toString方法打印舒服，但是人家要的是数组
            Object[] newArray = hs.toArray();
            int[] newIntArray = new int[hs.size()];
            for (int i = 0; i < newArray.length; i++) {
                newIntArray[i] = (int)newArray[i];
            }

        } else if ("2".equals(met)){
            int[] newArray = getModifyArray(array);
            System.out.println(Arrays.toString(newArray));
        }

    }

    public static HashSet<Integer> getHsMap(int[] array) {
        //自己瞎做的；
        HashSet<Integer> hs = new HashSet<>();
        for (int arr : array
        ) {
            hs.add(arr);
        }
        return hs;
    }

    public static int[] getModifyArray(int[] array) {

        if (array.length == 0) {
            return array;
        }
        int index = 0;
        for (int i = 1; i < array.length; i++
        ) {
            if (array[index] != array[i]) {   //[1,1,2,3]
                array[++index] = array[i];
            }
        }

        return Arrays.copyOfRange(array, 0, index + 1);
    }


}
