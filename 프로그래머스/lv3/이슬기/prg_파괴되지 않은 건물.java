/**
* 2차원 배열 누적합
0 0 0 0
0 -4 0 4
0 0 0 0
0 4 0 -4
*/
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] temp = new int[n+1][m+1];
        
        for (var i=0; i<skill.length; i++) {
            int type = skill[i][0], r1 = skill[i][1], c1 = skill[i][2], r2 = skill[i][3], c2 = skill[i][4], degree = skill[i][5];
            temp[r1][c1] += type == 1 ? -degree : degree;
            temp[r1][c2+1] += type == 1 ? degree : -degree;
            temp[r2+1][c1] += type == 1 ? degree : -degree;
            temp[r2+1][c2+1] += type == 1 ? -degree : degree;
        }
        
        for (var i=0; i<n; i++) {
            for (var j=0; j<m; j++) {
                temp[i][j+1] += temp[i][j];
            }
        }
        
        for (var j=0; j<m; j++) {
            for (var i=0; i<n; i++) {
                temp[i+1][j] += temp[i][j];
            }
        }
        
        for (var i=0; i<n; i++) {
            for (var j=0; j<m; j++) {
                board[i][j] += temp[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}