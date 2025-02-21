public class LC_1594 {
    class Solution {
        public int maxProductPath(int[][] grid) {
            int MOD = (int)(1e9 + 7);
            int row = grid.length;
            int col = grid[0].length;
            int[] dx = new int[]{-1, 0}; // 위->아래, 왼->오
            int[] dy = new int[]{0, -1};
    
            long[][] plus = new long[row+1][col+1];
            long[][] minus = new long[row+1][col+1];
            boolean hasZero = false;
    
            for(int i=1; i<row+1; i++){
                for(int j=1; j<col+1; j++){
                    int value = grid[i-1][j-1];
                    if(value == 0) hasZero = true;
    
                    if(i==1 && j==1){
                        if(value > 0){
                            plus[i][j] = value; 
                        } 
                        else{
                            minus[i][j] = value;
                        }
                        continue;
                    }
                    for(int k=0; k<2; k++){
                        int px = i+dx[k];
                        int py = j+dy[k];
                        if(value > 0){
                            plus[i][j] = Math.max(plus[i][j], value * plus[px][py]);
                            minus[i][j] = Math.min(minus[i][j], value * minus[px][py]);
                        }
                        else if(value < 0){
                            plus[i][j] = Math.max(plus[i][j], value * minus[px][py]);
                            minus[i][j] = Math.min(minus[i][j], value * plus[px][py]);
                        }
                        else{
                            plus[i][j] = 0;
                            minus[i][j] = 0;
                        }
                    }
                }
            }
        
            long result = plus[row][col];
            if(result==0){
                if(hasZero) return 0;
                return -1;
            }
            return (int) (result % MOD);
        }
    }    
}
