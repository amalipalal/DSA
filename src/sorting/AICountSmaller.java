package sorting;

import java.util.Arrays;

public class AICountSmaller {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 7};
        int[] ans = countSmaller(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, 0, n - 1, counts);
        return counts;
    }

    private static void mergeSort(int[] nums, int[] indexes,
                                  int left, int right, int[] counts) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, indexes, left, mid, counts);
        mergeSort(nums, indexes, mid + 1, right, counts);
        merge(nums, indexes, left, mid, right, counts);
    }

    private static void merge(int[] nums, int[] indexes,
                              int left, int mid, int right, int[] counts) {

        int[] tempNums = new int[right - left + 1];
        int[] tempIdx = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                counts[indexes[i]] += rightCount;
                tempNums[k] = nums[i];
                tempIdx[k++] = indexes[i++];
            } else {
                rightCount++;
                tempNums[k] = nums[j];
                tempIdx[k++] = indexes[j++];
            }
        }

        while (i <= mid) {
            counts[indexes[i]] += rightCount;
            tempNums[k] = nums[i];
            tempIdx[k++] = indexes[i++];
        }

        while (j <= right) {
            tempNums[k] = nums[j];
            tempIdx[k++] = indexes[j++];
        }

        for (int p = 0; p < k; p++) {
            nums[left + p] = tempNums[p];
            indexes[left + p] = tempIdx[p];
        }
    }
}
