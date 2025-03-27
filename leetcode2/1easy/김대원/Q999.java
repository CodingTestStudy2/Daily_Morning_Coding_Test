// 1. 아이디어 : 폰이 룩에 도달할 수 있는지 판단
// 2. 시간복잡도 : O(8 * 8 * 64)
// 3. 자료구조/알고리즘 : 완전탐색

class Solution {
    public int numRookCaptures(char[][] board) {
        Queue<int[]> pawns = new LinkedList<>();
        int[] rook = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rook[0] = i;
                    rook[1] = j;
                } else if (board[i][j] == 'p') {
                    pawns.offer(new int[] {i, j});
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;

        while (!pawns.isEmpty()) {
            int[] pawn = pawns.poll();
            if (pawn[0] != rook[0] && pawn[1] != rook[1]) continue;

            int x = pawn[0];
            int y = pawn[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while (isValid(nx, ny)) {
                    if (board[nx][ny] == 'R') {
                        answer++;
                        break;
                    } else if (board[nx][ny] != '.') break;

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        return answer;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}