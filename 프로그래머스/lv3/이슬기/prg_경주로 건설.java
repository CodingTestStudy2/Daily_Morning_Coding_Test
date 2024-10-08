/**
직선 -> 100원
코너 -> 500원
*/
import java.util.*;

class Solution {
    class Road {
        int x;
        int y;
        int cost;
        int arrow;
        int cnt;
        
        public Road(int x, int y, int cost, int arrow, int cnt) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.arrow = arrow;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][] distance = new int[n][n];
        for (int[] dist: distance)
            Arrays.fill(dist, Integer.MAX_VALUE);
        int[][] corner = new int[n][n];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<Road> q = new LinkedList<>();
        q.offer(new Road(0, 0, 0, -1, 0)); // x, y, 비용, 이전 방향, corner 개수
        distance[0][0] = 0;
        
        while (!q.isEmpty()) {
            Road road = q.poll();
            for (var i=0; i<4; i++) {
                int nx = dx[i] + road.x;
                int ny = dy[i] + road.y;
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (board[nx][ny] == 1) continue;
                    
                    if (road.arrow == -1) {
                        distance[nx][ny] = road.cost+100;
                        corner[road.x][road.y] = road.cnt;
                        q.offer(new Road(nx, ny, road.cost+100, i, road.cnt));
                    } else if (road.arrow == i && road.cost+100 <= distance[nx][ny]) {
                        distance[nx][ny] = road.cost+100;
                        corner[road.x][road.y] = road.cnt;
                        q.offer(new Road(nx, ny, road.cost+100, i, road.cnt));
                    } else if (road.arrow != i && road.cost+600 <= distance[nx][ny]) {
                        distance[nx][ny] = road.cost+600;
                        corner[road.x][road.y] = road.cnt+1;
                        q.offer(new Road(nx, ny, road.cost+600, i, road.cnt+1));
                    } else if (road.arrow != i && corner[nx][ny] > road.cnt+1) {
                        if ((corner[nx][ny] - road.cnt+1) * 500 > road.cost+600 - distance[nx][ny]) {
                            distance[nx][ny] = road.cost+600;
                            corner[road.x][road.y] = road.cnt+1;
                            q.offer(new Road(nx, ny, road.cost+600, i, road.cnt+1));
                        }
                    }
                }
            }
        }
        
        //System.out.println(Arrays.deepToString(distance));
        
        return distance[n-1][n-1];
    }
}