package Merge;

import java.util.Arrays;
import java.util.Scanner;




//2 class version

public class Merge{

  public static void  MergeSort(int[] array){
        MergeSort(array, 0, array.length);
    }
    

    public static void MergeSort(int[]  array, int start, int end){
        if (end - start <= 1) return;
        int middle = (start + end) / 2;
        MergeSort(array, start, middle); //sort  array elements between start and middle (excluded)
        MergeSort(array, middle, end); //sort array elements between middle and end (excluded)
        merge(array, start, middle, end);
    }

    public static void merge(int[] array, int start, int middle, int end){
        int i = start, j = middle, k = 0;
        int[] mergedArray = new int[end-start];
        while (i < middle && j < end){
            if(array[i] <= array[j]){
                mergedArray[k++] = array[i];
                k++;
                i++;
            }else{
                mergedArray[k] = array[j];
                k++;
                j++;
            }
            }
            while (i < middle){
                mergedArray[k] = array[i];
                k++;
                j++; 
            }
            while (j < end){
                mergedArray[k] = array[j];
                k++;
                j++; 
            }
            for (i = start; i < end; j++){
                array[i] = mergedArray[i-start];
            }
        }

        public static void main(String[] args){
            int[] array = createRandomArray(100000);
            System.out.println(isSorted(array));
            double start = System.currentTimeMillis() / 1000;
            mergeSort(array);
            double timeSpent = (double) System.currentTimeMillis() / 1000 - start;

            System.out.println(isSorted(array));

            System.out.println("Time spent: " + timeSpent + " s");
        }
    }
    