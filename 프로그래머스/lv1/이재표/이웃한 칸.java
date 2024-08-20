import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        String color=board[h][w];
        for(int i=0;i<4;i++){
            if(0<=h+dy[i]&&h+dy[i]<board.length&&0<=w+dx[i]&&w+dx[i]<board[0].length){
                int y=h+dy[i];
                int x=w+dx[i];
                if(board[y][x].equals(color)){
                    answer++;
                }
            }
        }
        return answer;
    }
}
