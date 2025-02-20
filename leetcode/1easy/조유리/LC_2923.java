public class LC_2923 {
    class Solution {
        public int findChampion(int[][] grid) {
            // 1 이 없는 col 고르기
            int winner = -1;
            for(int j=0; j<grid[0].length; j++){
                boolean lose = false;
                for(int i=0; i<grid.length; i++){
                    if(grid[i][j] == 1){
                        lose = true;
                        break;
                    }
                }
                if(!lose) winner = j;
            }
            return winner;
        }
    }
}
