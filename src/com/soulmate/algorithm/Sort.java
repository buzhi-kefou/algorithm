package com.soulmate.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        for(int j=0;j<=20000;j++){
            int[] arr1=new int[j];
            System.out.println("size: "+j);
            for (int i = 0; i < arr1.length; i++)
                arr1[i]=(int)((100010)*Math.random());
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            try{
                radixSort(arr2);
            }catch (Exception e){
                System.out.println(Arrays.toString(arr1));
                System.out.println(e.getMessage());
                return;
            }

            if(!test(arr2)){
                System.out.println("arr1: "+Arrays.toString(arr1));
                System.out.println("arr2: "+Arrays.toString(arr2));
                break;
            }
        }
    }

    public static boolean test(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i])
                return false;
        }
        return true;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0, k = 0; i < arr.length; i++, k = i) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[k])
                    k = j;
            }
            if (k != i)
                swap(arr, i, k);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--)
                swap(arr, j - 1, j);
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int ptr = 0, ptr1 = l, ptr2 = m + 1;
        while (ptr1 <= m && ptr2 <= r) {
            if (arr[ptr1] <= arr[ptr2])
                temp[ptr++] = arr[ptr1++];
            else
                temp[ptr++] = arr[ptr2++];
        }
        while (ptr1 <= m)
            temp[ptr++] = arr[ptr1++];
        while (ptr2 <= r)
            temp[ptr++] = arr[ptr2++];
        while (ptr > 0)
            arr[--ptr2] = temp[--ptr];
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (r - l) / 2, r);
            int[] equal = partition(arr, l, r, arr[r]);
            quickSort(arr, ++equal[1], r);
            quickSort(arr, l, equal[0]);
        }
    }

    private static int[] partition(int[] arr, int l, int r, int val) {
        int ptr1 = l - 1, ptr2 = r, ptr = l;
        while (ptr < ptr2) {
            if (arr[ptr] == val) {
                ptr++;
            } else {
                if (arr[ptr] > val)
                    swap(arr, --ptr2, ptr);
                else
                    swap(arr, ++ptr1, ptr++);
            }
        }
        swap(arr, r, ptr2);
        return new int[]{ptr1, ptr2};
    }

    public static void heapSort(int[] arr) {
        int len = arr.length - 1;
        int beg = (arr.length >> 1) - 1;
        for (int i = beg; i >= 0; i--)
            heapify(arr, i, len);
    }

    private static void heapify(int[] arr, int ptr, int len) {
        int left = (ptr << 1) + 1;
        int right = left + 1;
        int max = left;
        if (left > len)
            return;
        if (right <= len && arr[right] > arr[left])
            max = right;
        if (arr[max] > arr[ptr]) {
            swap(arr, max, ptr);
            heapify(arr, max, len);
        }
    }

    public static void bucketSort(int[] arr) {
        int[] temp = new int[10010];
        for (int ptr : arr) {
            temp[ptr]++;
        }
        int pos = 0, cnt = 0;
        while (cnt < arr.length) {
            while (temp[pos] != 0) {
                arr[cnt++] = pos;
                temp[pos]--;
            }
            pos++;
        }
    }

    public static void radixSort(int[] arr) {
        ArrayList<List<Integer>> temp = new ArrayList<>(10);
        int pos, cmp, tmp = 1, ten = 10, cnt = arr.length;
        while (temp.size() < 10)
            temp.add(new LinkedList<>());
        while (cnt > 0) {
            cnt = arr.length;
            for (int val : arr) {
                cmp = val / tmp;
                pos = cmp % ten;
                temp.get(pos).add(val);
                if (cmp == 0)
                    cnt--;
            }
            pos = 0;
            tmp *= 10;
            for (List<Integer> list : temp) {
                while (!list.isEmpty()) {
                    arr[pos++] = list.remove(0);
                }
            }
        }
    }

    public static void shellSort(int[] arr) {

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
