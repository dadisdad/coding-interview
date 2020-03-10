package com.dadisdad.coding;

/**
 * 旋转数组的最小数字
 * @author 10308
 * @date 2020/3/11
 */
public class MinNumberInRotatedArray {

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length ==0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length-1;
        int minIndex = 0;
        while (left<right) {
            if (right-left==1) {
                minIndex = right;
                break;
            }
            int mid = (left+right)>>1;
            if (numbers[left] == numbers[right] && numbers[mid] == numbers[right]) {
                minIndex = left;
                for (int i = left; i <= right ; i++) {
                    if (numbers[i]<numbers[minIndex]) {
                        minIndex = i;
                    }
                }
                return numbers[minIndex];
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[minIndex];
    }

    public static int minArrayII(int[] numbers) {
        if (numbers == null || numbers.length ==0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length-1;
        while (left<right) {
            int mid = (left+right)>>1;
            if (numbers[mid]>numbers[right]) {
                left = mid+1;
            } else if (numbers[mid]<numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {2,2,2,0,1};
        int[] arr3 = {1,0,1,1,1};
        int[] arr4 = {1,1,1,0,1};

        System.out.println(minArray(arr1));
        System.out.println(minArray(arr2));
        System.out.println(minArray(arr3));
        System.out.println(minArray(arr4));

        System.out.println(minArrayII(arr1));
        System.out.println(minArrayII(arr2));
        System.out.println(minArrayII(arr3));
        System.out.println(minArrayII(arr4));
    }
}
