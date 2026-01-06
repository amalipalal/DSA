package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7};
        System.out.println(minimumArrLength(arr));
    }

    public static void sortArray(int[] arr) {
        int arrayLength = arr.length;

        for (int i = 1; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int minimumArrLength(int[] arr) {
        int arrayLength = arr.length;

        while (true) {
            boolean hasBeenSwapped = false;

            for (int j = 0; j < arrayLength - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    hasBeenSwapped = true;
                }
            }

            if (!hasBeenSwapped) break;

            arrayLength--;
        }

        return arrayLength;
    }
}
