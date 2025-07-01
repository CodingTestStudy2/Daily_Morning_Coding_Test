package Leetcode.김도연;

public class Q3402 {
    public int minimumOperations(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length-1; j++) {
                if (grid[j][i] >= grid[j+1][i]) {
                    sum += grid[j][i] - grid[j+1][i] + 1;
                    grid[j+1][i] = grid[j][i] + 1;
                }
            }
        }

        return sum;
    }
}
