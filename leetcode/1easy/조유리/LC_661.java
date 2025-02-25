public class LC_661 {
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int row = img.length;
            int col = img[0].length;
            int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
            int[][] ans = new int[row][col];
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    int sum = 0;
                    int cnt = 0;
                    for(int k=0; k<9; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(inRange(nx, ny, row, col)){
                            sum += img[nx][ny];
                            cnt++;
                        }
                    }
                    ans[i][j] = sum / cnt;
                }
            }
            return ans;
        }
    
        public boolean inRange(int x, int y, int row, int col){
            return x>=0 && x<row && y>=0 && y<col;
        }
    }
}
