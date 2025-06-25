class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int n = 8;
        int answer = Integer.MAX_VALUE;

        if (a == e || b == f) {
            if (a == e && a == c) {
                if ((f > b && d < f && b < d) || (f < b && f < d && d < b)) answer = Math.min(3, answer);
                else answer = Math.min(1, answer);
            } else if (b == f && b == d) {
                if ((a > e && c > e && c < a) || (a < e && c < e && c > a)) answer = Math.min(3, answer);
                else answer = Math.min(1, answer);
            } else {
                answer = Math.min(1, answer);
            }
        } else answer = Math.min(2, answer);

        boolean flag = false;
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, 1, -1};
        for (int i = 0; i < 4; i++) {
            if (flag) break;
            int x = c, y = d;

            while (x >= 1 && x <= n && y >= 1 && y <= n) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx == a && ny == b) break;
                if (nx == e && ny == f) {
                    flag = true;
                    break;
                }

                x = nx;
                y = ny;
            }
        }

        if (flag) answer = Math.min(1, answer);
        else answer = Math.min(2, answer);

        return answer;
    }
}
