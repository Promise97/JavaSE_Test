package com.xyj.sort;

import java.util.Arrays;

public class Sort {
    private static int[] a = new int[]{4,6,9,3,2,5,8,1,7};
    //交换数组元素的方法
    public static void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //选择排序
    public static void selectSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1;j < array.length; j++){
                if (array[j] < array[min])
                    min = j;
            }
            swap(array, i, min);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array){
        for(int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j + 1])
                    swap(array, j, j+1);
            }
        }
    }

    //插入排序
    public static void insertSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j > 0 && array[j] < array[j - 1]; j--){
                swap(array , j, j - 1);
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] array, int left, int right){
        if (left == right)
            return;
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    //归并过程
    public static void merge(int[] array, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            help[index++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid){
            help[index++] = array[p1++];
        }
        while (p2 <= right){
            help[index++] = array[p2++];
        }
        for(int i = 0; i <help.length; i++){
            array[left + i] = help[i];
        }
    }

    //快速排序
    public static void quickSort(int[] array, int left, int right){
        if(left >= right)
            return;
        int p1 = left + 1, p2 = right;
        while (p1 < p2){
            while (array[p2] >= array[left]){
                p2--;
            }
            while (array[p1] <= array[left] && p1 < p2){
                p1++;
            }
            swap(array, p1, p2);
        }
        swap(array, left, p1);
        quickSort(array, left, p1 - 1);
        quickSort(array, p1 + 1, right);
    }

    //堆排序
    public static void heapSort(int[] array){
        //构建堆
        for(int i = 0; i < array.length; i++){
            heapInsert(array, i);
        }
        int size = array.length;
        swap(array, 0, --size);
        while (size > 0){
            //使堆顶元素下沉
            heapify(array, 0, size);
            swap(array, 0, --size);
        }
    }

    private static void heapify(int[] array, int index, int size) {
        int left = index * 2 + 1;
        while (left < size){
            //取出左右子节点中大的一项
            int largest = left + 1 < size && array[left] < array[left + 1] ? left + 1 : left;
            largest = array[index] < array[largest] ? largest : index;
            if(largest == index)
                break;
            swap(array, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private static void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]){
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void test(){

    }
    public static void main(String[] args){
        Arrays.stream(a).forEach(System.out::print);
        heapSort(a);
        System.out.println();
        Arrays.stream(a).forEach(System.out::print);
    }
}
