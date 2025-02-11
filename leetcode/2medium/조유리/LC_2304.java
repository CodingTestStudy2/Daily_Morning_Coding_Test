import java.util.Arrays;

public class LC_2304 {
    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int row = grid.length, col = grid[0].length;
            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for(int i=0; i<row-1; i++){
                for(int j=0; j<col; j++){
                    int value = grid[i][j];
                    if(i==0){ dp[i][j] = grid[i][j];}
                    for(int k=0; k<col; k++){
                        dp[i+1][k] = Math.min(dp[i][j]+moveCost[value][k]+grid[i+1][k] , dp[i+1][k]);
                    }
                }
            }
            int ans = dp[row-1][0];
            for(int j=1; j<col; j++){
                ans = Math.min(ans, dp[row-1][j]);
            }
            return ans;
        }
    }
}
