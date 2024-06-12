package org.jingyes.j2se.code01;

import java.util.Arrays;

/**
 * @author jingyes
 * @date 17/12/25
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //foreach循环数组
        int[] arr = {1, 3, 5, 7, 9};
        for (int item : arr) {
            System.out.println(item);
        }

        //打印数组
        System.out.println(Arrays.toString(arr));//输出 [1, 3, 5, 7, 9]
        int[][] arrM = {{1, 2, 3}, {11, 12, 13}, {21, 22, 23}};
        System.out.println(Arrays.deepToString(arrM));//[[1, 2, 3], [11, 12, 13], [21, 22, 23]]

        //自定义toString()方法
        System.out.println("s=" + toString(arr));

        //拷贝数组元素
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr2));//输出   [1, 3, 5, 7, 9]
        int[] arr3 = Arrays.copyOf(arr, arr.length / 2);
        System.out.println(Arrays.toString(arr3));//输出 [1, 3]
        int[] arr4 = Arrays.copyOf(arr, arr.length * 2);
        System.out.println(Arrays.toString(arr4));//输出 [1, 3, 5, 7, 9, 0, 0, 0, 0, 0]


        //排序
        int[] arr6 = {12, 4, 53, 78, 21, 943, 3};
        Arrays.sort(arr6);
        System.out.println(Arrays.toString(arr6));//输出 [3, 4, 12, 21, 53, 78, 943]

        //查找
        //输出2
        System.out.println(Arrays.binarySearch(arr6, 12));
        //输出7，及-(low+1)=7，所以如果该元素插入数组的位置应该是6
        System.out.println(Arrays.binarySearch(arr6, 100));

        System.out.println(Arrays.toString(arr6));
        System.out.println("自定义二分查找53");
        System.out.println(binarySearch(arr6, 53));

        //填充数组元素
        String[] arr7 = new String[5];
        Arrays.fill(arr7, "*");
        System.out.println(Arrays.toString(arr7));//[*, *, *, *, *]

        //比较数组元素
        String[] arr8 = {"*", "*", "*", "*", "*",};
        System.out.println(arr7.equals(arr8));//false
        System.out.println(Arrays.equals(arr7, arr8));//true
    }

    private static String toString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        int iMax = arr.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; ; i++) {
            builder.append(arr[i]);
            if (i == iMax) {
                return builder.append("]").toString();
            } else {
                builder.append(",");
            }
        }
    }

    private static int binarySearch(int[] arr, int v) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (v < arr[mid]) {
                high = mid - 1;
            } else if (v > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
