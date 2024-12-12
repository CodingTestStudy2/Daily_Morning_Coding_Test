import java.util.*;
class Solution{
    public int solution(int [][]board){
        int n=board.length;
        int m=board[0].length;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(board[i][j]==0){
                    continue;
                }
                int up=Integer.MAX_VALUE;
                int left=Integer.MAX_VALUE;
                int cross=Integer.MAX_VALUE;
                if(j-1>=0){
                    up=board[i][j-1];
                }
                if(i-1>=0){
                    left=board[i-1][j];
                }
                if(j-1>=0 && i-1>=0){
                    cross=board[i-1][j-1];
                }
                int min=up;
                min=Math.min(min,left);
                min=Math.min(min,cross);
                board[i][j]=min+1;
            }
        }
        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                answer=Math.max(board[i][j],answer);
            }
        }
        return answer*answer;
    }
}
