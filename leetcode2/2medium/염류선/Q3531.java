package Leetcode.염류선;

public class Q3531 {
    static boolean[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int countCoveredBuildings(int n, int[][] buildings) {
        int answer = 0;
        graph = new boolean[n + 2][n + 2];

        for (int[] xy : buildings) {
            int x = xy[0];
            int y = xy[1];
            graph[x][y] = true;
        }

        for (int[] xy : buildings) {
            int x = xy[0];
            int y = xy[1];

            boolean isCovered = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!graph[nx][ny]) {
                    isCovered = false;
                    break;
                }
            }

            if (isCovered) {
                answer++;
            }
        }

        return answer;
    }
}
