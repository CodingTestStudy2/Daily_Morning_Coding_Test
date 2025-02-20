public class LC2923 {
    public int findChampion(int[][] grid) {
        int maxValue = -1;
        int maxIdx = -1;
        for(int i = 0; i < grid.length; i++){
            int count = 0;
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
            if(count > maxValue){
                maxValue = count;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
