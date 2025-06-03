package Leetcode.이재훈;

/*
1. 아이디어 :

 - R 의 주소를 찾은뒤에 위 아래 왼쪽 오른쪽 탐색하는 방식

2. 시간복잡도 :
O( n**2 )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q999 {
    class Solution {
        private class Coordinate {
            int x;
            int y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }


        public int numRookCaptures(char[][] board) {

            //find where the white rook
            //from the place where the white rook is, move vertically or horizontally to find "p"
            //
            int rowLength = board.length;
            int colLength = board[0].length;
            Coordinate rCoordinate = null;

            for(int i = 0; i<rowLength; i++) {
                for(int j = 0; j <colLength; j++) {
                    if(board[i][j] == 'R') {
                        rCoordinate = new Coordinate(i,j);
                    }
                }
            }
            int count = 0;

            int x = rCoordinate.x;
            int y = rCoordinate.y;

            // check left;
            for(int i = y; i>=0; i--) {
                if(board[x][i] == 'B') break;

                if(board[x][i] == 'p') {
                    count++;
                    break;
                }
            }

            // check right;
            for(int i = y; i<colLength; i++) {
                if(board[x][i] == 'B') break;

                if(board[x][i] == 'p') {
                    count++;
                    break;
                }
            }
            // check top;
            for(int i = x; i>=0; i--) {
                if(board[i][y] == 'B') break;

                if(board[i][y] == 'p') {
                    count++;
                    break;
                }
            }
            // check bottom;
            for(int i = x; i<rowLength; i++) {
                if(board[i][y] == 'B') break;

                if(board[i][y] == 'p') {
                    count++;
                    break;
                }
            }
            return count;
        }
    }
}