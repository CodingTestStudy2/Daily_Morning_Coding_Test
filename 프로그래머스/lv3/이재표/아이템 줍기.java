import java.util.*;

class Solution {
    char[][] arr;
    int min = Integer.MAX_VALUE;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        min = Integer.MAX_VALUE;
        arr = new char[101][101];
        characterX*=2;
        characterY*=2;
        itemX*=2;
        itemY*=2;
        
        // Fill rectangles
        for (int i = 0; i < rectangle.length; i++) {
            int[] rec = rectangle[i];
            int sx = rec[0]*2;
            int sy = rec[1]*2;
            int ex = rec[2]*2;
            int ey = rec[3]*2;
            for (int x = sx; x <= ex; x++) {
                for (int y = sy; y <= ey; y++) {
                    if(arr[y][x]=='1'){
                        continue;
                    }
                    arr[y][x]='1';
                    if(x==sx || x==ex || y==sy || y==ey){
                        arr[y][x]='2';
                    }
                }
            }
        }
        
        boolean[][] visit = new boolean[101][101];
        dfs(characterX, characterY, itemX, itemY, visit, 0);
        return min/2;
    }

    public void dfs(int characterX, int characterY, int itemX, int itemY, boolean[][] visit, int cnt) {
        visit[characterY][characterX] = true;
        if (characterY == itemY && characterX == itemX) {
            min = Math.min(min, cnt);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = characterX + dx[i];
            int ny = characterY + dy[i];
            if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && !visit[ny][nx] && arr[ny][nx] == '2') {
                visit[ny][nx] = true;
                dfs(nx, ny, itemX, itemY, visit, cnt + 1);
                visit[ny][nx] = false;
            }
        }
    }
}
