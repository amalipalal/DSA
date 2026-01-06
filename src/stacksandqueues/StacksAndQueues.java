package stacksandqueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StacksAndQueues {

    public static void main(String[] args) {
        int[] input = {30, 40, 50 , 60};
        System.out.println("Days till warmer temp: " + Arrays.toString(daysTillWarmerTemperature(input)));

        int[][] oranges = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("Time to rot: " + timeToRot(oranges));
    }

    public static int[] daysTillWarmerTemperature(int[] temperatures) {
        Stack<Integer> store = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int currentIndex = 0; currentIndex < temperatures.length; currentIndex++ ) {
            int currentTemperature = temperatures[currentIndex];
            while (!store.empty() && temperatures[store.peek()] < currentTemperature) {
                int storedIndex = store.pop();
                ans[storedIndex] = currentIndex - storedIndex;
            }
            store.push(currentIndex);
        }

        return ans;
    }

    public static int timeToRot(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        Queue<int[]> rottQueue = new LinkedList<>();
        int freshOranges = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if(grid[row][col] == 2) {
                    int[] pair = {row, col};
                    rottQueue.add(pair);
                } else if(grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        while (!rottQueue.isEmpty() && freshOranges > 0)  {
            int breadthLength = rottQueue.size();
            minutes++;

            for (int i = 0; i < breadthLength; i++) {
                int[] orangePair = rottQueue.remove();

                for (int[] direction : directions) {
                    int newRow = orangePair[0] + direction[0];
                    int newCol = orangePair[1] + direction[1];
                    if (newRow >= rowLength || newRow < 0 || newCol >= colLength || newCol < 0)
                        continue;

                    if(grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        rottQueue.add(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
