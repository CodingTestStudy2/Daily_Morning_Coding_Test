import java.util.LinkedList;
import java.util.Queue;

public class LC_1020 {
    public int numEnclaves(int[][] grid) {
        // move : 인접한 land cell로 가기 or grid의 경계 밖으로 가기
        // grid 밖으로 벗어날 수 없는 land cell의 갯수 return
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] out = new boolean[row][col];

        // 경계 밖으로 나가려면 나와 인접한 cell이 밖으로 나갈 수 있는 cell과 인접해야 한다.
        // 경계 설정
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            if(i==0 || i==row-1){
                for(int j=0; j<col; j++){
                    if(grid[i][j] == 1){
                    out[i][j] = true;
                    q.add(new Pair(i, j));
                    }
                }
            }
            else{
                if(grid[i][0] == 1){
                    out[i][0] = true;
                    q.add(new Pair(i, 0));
                }
                if(grid[i][col-1] == 1){
                    out[i][col-1] = true;
                    q.add(new Pair(i, col-1));
                }
            }
        }

        // bfs
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            Pair p = q.poll(); // 밖으로 나갈 수 있는 cell 
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(inRange(nx, ny, row, col) && grid[nx][ny]==1 && !out[nx][ny]){
                    out[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        // 결과 출력
        int ans = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==1 && !out[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }

    static boolean inRange(int x, int y, int row, int col){
        return x>=0 && x<row && y>=0 && y<col;
    }

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}