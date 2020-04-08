package com.yuntian.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author guangleilei.
 * @date Created in 9:29 2019/12/16
 * @description
 */
public class TestSort {


    @Test
    public void testBubbleSort() {
        int[] arr = {2, 3, 5, 6, 7};
        bubbleOrderSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSelectOrder() {
        int[] arr = {2, 3, 5, 6, 7};
        selectOrderSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testInsertOrder() {
        int[] arr = {1, 2, 3};
        insertOrderSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testQuickOrder() {
        int[] arr = {4, 3, 2, 1};
        quickOrderSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void quickOrderSort(int[] arr) {
        quickOrderSort(arr, 0, arr.length - 1);
    }

    /**
     * 4,3,2,5,6     4  3,2,5,6   3,2,4,5,6
     *
     * @param arr
     * @param low
     * @param high
     */
    private void quickOrderSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partation(arr, low, high);
        quickOrderSort(arr, low, p - 1);
        quickOrderSort(arr, p + 1, high);
    }

    private int count = 0;

    private int partation(int[] arr, int low, int high) {
        int pavite = low;
        //游标记录
        int index = pavite + 1;
        for (int i = index; i < arr.length; i++) {
            if (arr[pavite] > arr[i]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pavite, index - 1);
        return index - 1;
    }


    /**
     * 2,3,6,7,5->   2,3, 5 ,6,7,   1,2,3
     * 首部有序 2,3,6,7  5
     *
     * @param arr
     */
    private void insertOrderSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int preIndex = i;
            int insert = arr[i + 1];
            for (int j = i; j >= 0 && arr[j] > insert; j--) {
                arr[j + 1] = arr[j];
                //移动位置
                preIndex--;
            }
            arr[preIndex + 1] = insert;
        }
    }


    /**
     * 4,3,2,1 -> 3,2,1,4
     * 3,2,1,4 -> 2,1,4,3
     *
     * @param arr
     */
    public void bubbleOrderSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }

    /**
     * 4,3,2,1 -> 1,3,2,4
     * 1,3,2,4 -> 1,2,3,4
     *
     * @param arr
     */
    public void selectOrderSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }

    }




    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}
