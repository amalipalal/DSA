package others;

import java.util.Arrays;

public class DsaLive {

    public static void main(String[] args) {
        int[][] numbers = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        int[] diagonalNumbers = diagonalLoop(numbers);
        for (int num : diagonalNumbers) {
            System.out.printf("%d ", num);
        }

        System.out.println(Arrays.toString(diagonalNumbers));
    }

    public static int[] diagonalLoop(int[][] arr) {
        int[] outputArr = new int[arr.length];

        for (int post = 0; post < arr.length; post++) {
            outputArr[post] = arr[post][post];
        }

        return outputArr;
    }

    public static int maximumSubarraySum(int[] arr) {
        int maximumSum = arr[0];
        int currentSum = arr[0];

        for (int num : arr) {
            if (currentSum < 0)
                currentSum = 0;

            currentSum += num;
            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }
}
