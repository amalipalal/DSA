package sorting;

import java.util.Arrays;

class Pair {
    public int index;
    public int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class CountSmallerNoPair {

    public static void main(String[] args) {
        int[] nums = {10, 9, 20, 7};
        int[] ans = countSmaller(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] countSmaller(int[] nums){
        int len = nums.length;
        int[] count = new int[len];

        Pair[] pairs = new Pair[len];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        mergeSort(pairs, count);
        return count;
    }

    public static void mergeSort(Pair[] arr, int[] count) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;

        Pair[] left = new Pair[mid];
        Pair[] right = new Pair[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, count);
        mergeSort(right, count);

        merge(arr, count, left, right);
    }

    private static void merge(Pair[] arr, int[] count, Pair[] left, Pair[] right) {
        int i = 0, j = 0, k = 0;
        int rightCount = 0;

        while (i < left.length && j < right.length) {
            if (left[i].value <= right[j].value) {
                count[left[i].index] += rightCount;
                arr[k++] = left[i++];
            } else {
                rightCount++;
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            count[left[i].index] += rightCount;
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
