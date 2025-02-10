import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC_1254 {
    class Solution {
        public int closedIsland(int[][] grid) {
            int cnt = 2;
            int[] dx = new int[]{0, 0, 1, -1};
            int[] dy = new int[]{1, -1, 0, 0};
            while(true){
                int[] start = newIsland(grid);
                if(start[0] == -1 && start[1] == -1) break;

                // bfs
                Queue<Coor> q = new LinkedList<>();
                q.add(new Coor(start[0], start[1]));
                while(!q.isEmpty()){
                    Coor c = q.remove();
                    grid[c.x][c.y] = cnt;
                    for(int i=0; i<4; i++){
                        int nx = c.x + dx[i];
                        int ny = c.y + dy[i];
                        if(inRange(nx, ny, grid) && grid[nx][ny] == 0){
                            q.add(new Coor(nx, ny));
                        }
                    }
                }
                cnt++;
            }
            
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    set.add(grid[i][j]);
                }
            }
            set.remove(1);
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1) set.remove(grid[i][j]);
                }
            }
            return set.size();
        }

        // 0 값을 가진 좌표가 없으면 (-1, -1)을 return
        public int[] newIsland(int[][] grid){
            int[] coor = new int[]{-1, -1};
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == 0){
                        coor[0] = i;
                        coor[1] = j;
                        break;
                    }
                }
            }
            return coor;
        }

        public boolean inRange(int x, int y, int[][] grid){
            return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
        }

        class Coor{
            int x;
            int y;
            Coor(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}
