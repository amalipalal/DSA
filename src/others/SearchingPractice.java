package others;

public class SearchingPractice {

    public static void main(String[] args) {
        String[] receipt = {"Orange", "Pineapple", "Avocado", "Meat"};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Avocado Search (Linear): " + "At position " + findItem(receipt, "Avocado") + "\n");
        System.out.println("Number guess (binary): " + "The number you are thinking of is " + findItem(arr, 3, arr.length - 1, 0));
        System.out.println("Number guess (binary): " + "The number you are thinking of is " + findItem(arr, 3));

    }

    private static int findItem(String[] receipt, String target) {
        int length = receipt.length;

        if(length == 0) return -1;
        if(target.equals(receipt[0])) return 0;
        if(target.equals(receipt[length - 1])) return length - 1;

        for (int index = 0; index < length; index++) {
            if (receipt[index].equals(target)) return index;
        }

        return -1;
    }

    private static int findItem(int[] arr, int target) {

        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentValue = arr[mid];

            System.out.println("Guess -> " + currentValue);

            if (currentValue > target) high = mid - 1;
            else if (currentValue < target) low = mid + 1;
            else return currentValue;
        }

        return -1;
    }

    private static int findItem(int[] arr, int target, int high, int low) {
        if(low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] > target) return findItem(arr, target, mid - 1, low);
        else if (arr[mid] < target) return findItem(arr, target, high, mid + 1);
        else return arr[mid];
    }
}
