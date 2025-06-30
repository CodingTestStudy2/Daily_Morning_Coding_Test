class Solution {

    static int[][] board;
    static List<List<String>> answer;

    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        answer = new ArrayList<>();
        backtrack(0, n);

        return answer;
    }

    private void backtrack(int qc, int n) {
        if (qc == n) {
            StringBuilder sb = new StringBuilder();
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }

                result.add(new String(sb.toString()));
                sb.setLength(0);
            }

            answer.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPos(qc, i, n)) {
                board[qc][i] = 1;
                backtrack(qc + 1, n);
                board[qc][i] = 0;
            }

        }
    }

    private boolean canPos(int x, int y, int n) {
        int[] dx = {-1, -1, 1, 1}, dy = {-1, 1, 1, -1};
        // 상하좌우
        for (int i = 0; i < n; i++) {
            if (board[x][i] == 1 || board[i][y] == 1) return false;
        }

        // 대각선
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 1) return false;
                nx += dx[i];
                ny += dy[i];
            }
        }

        return true;
    }
}

// 1 <= n <= 9
