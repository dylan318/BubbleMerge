package ArrayListMOD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayListMOD {


    public static void swap(ArrayList<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void bubbleSort(ArrayList<Integer> array) {
        bubbleSort(array, 0, array.size());
    }

    public static void bubbleSort(ArrayList<Integer> array, int start, int end) {
        if (end - start <= 1)
            return;

        for (int i = start; i < end - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                swap(array, i, i + 1);
            }
        }

        bubbleSort(array, start, end - 1);
    }

    public static boolean isSorted(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1))
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> createRandomArray(int length) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array.add(random.nextInt(100)); // Generate random integers between 0 and 99
        }
        return array;
    }

    public static void writeArrayToFile(ArrayList<Integer> array, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        for (int i = 0; i < array.size(); i++) {
            fileWriter.write(array.get(i) + "\n");
        }

        fileWriter.close();
    }

    public static ArrayList<Integer> readArrayFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            arrayList.add(Integer.parseInt(scanner.nextLine()));
        }
        scanner.close();
        return arrayList;
    }

    public static void mergeSort(ArrayList<Integer> array) {
        mergeSort(array, 0, array.size());
    }

    public static void mergeSort(ArrayList<Integer> array, int start, int end) {
        if (end - start <= 1)
            return;
        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle, end);
        merge(array, start, middle, end);
    }

    public static void merge(ArrayList<Integer> array, int start, int middle, int end) {
        int i = start, j = middle, k = 0;
        ArrayList<Integer> mergedArray = new ArrayList<>(end - start);
        while (i < middle && j < end) {
            if (array.get(i) <= array.get(j)) {
                mergedArray.add(array.get(i));
                k++;
                i++;
            } else {
                mergedArray.add(array.get(j));
                k++;
                j++;
            }
        }
        while (i < middle) {
            mergedArray.add(array.get(i));
            k++;
            i++;
        }
        while (j < end) {
            mergedArray.add(array.get(j));
            k++;
            j++;
        }
        for (i = start; i < end; i++) {
            array.set(i, mergedArray.get(i - start));
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> array = createRandomArray(10000000);
        // ArrayList<Integer> array = createRandomArray(10);
        // writeArrayToFile(array, "array.txt");
        // ArrayList<Integer> array = readArrayFromFile("array.txt");
        System.out.println(isSorted(array));
        // System.out.println(array);
        double start = (double) System.currentTimeMillis() / 1000;

        // bubbleSort(array);
        mergeSort(array);

        double timeSpent = (double) System.currentTimeMillis() / 1000 - start;

        // writeArrayToFile(array, "sorted_array.txt");
        System.out.println(isSorted(array));
        // System.out.println(array);
        System.out.println("Time spent: " + timeSpent + " s");
    }
}
