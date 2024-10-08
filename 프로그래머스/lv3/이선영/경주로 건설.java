import java.util.*;

class Solution {
    static int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dc = {1, 0, -1, 0}; 

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4]; // 각 방향별 비용을 저장할 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE); // 초기값을 매우 크게 설정
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
        
        // 초기값: 시작점(0, 0)에서 각 방향으로 출발 (동서남북)
        for (int i = 0; i < 4; i++) {
            pq.offer(new int[]{0, 0, i, 0}); // 시작점 좌표 (0, 0), 방향 i, 비용 0
            cost[0][0][i] = 0;
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int dir = curr[2]; // 현재 방향
            int currCost = curr[3]; // 현재까지의 비용

            if (r == n - 1 && c == n - 1) {
                return currCost; // 도착지에 도달하면 비용 반환
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || board[nr][nc] == 1) {
                    continue; // 경계 밖이거나 벽인 경우 패스
                }

                int newCost = currCost + (dir == i ? 100 : 600); // 직선도로(100) 또는 코너(500) 추가

                if (cost[nr][nc][i] > newCost) {
                    cost[nr][nc][i] = newCost;
                    pq.offer(new int[]{nr, nc, i, newCost});
                }
            }
        }

        return Integer.MAX_VALUE; // 경로가 없을 때 (문제 조건상 발생하지 않음)
    }
}
