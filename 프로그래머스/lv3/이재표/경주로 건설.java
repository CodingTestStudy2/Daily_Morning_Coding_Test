import java.util.*;
class Solution {
    static int[][][]price;
    static int[][]visit;
    //상 좌 하 우
    static int[]dx={0,-1,0,1};
    static int[]dy={-1,0,1,0};
    public static int solution(int[][] board) {
        int answer = 0;
        visit=board;
        price=new int[board.length][board.length][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Arrays.fill(price[i][j], Integer.MAX_VALUE);
            }
        }

        bruteforce(0,0,2,0);
        bruteforce(0,0,3,0);
        int min = price[board.length-1][board.length-1][0];
        for (int i = 1; i < 4; i++) {
            min = Math.min(min, price[board.length - 1][board.length - 1][i]);
        }
        return min;
    }

    public static void bruteforce(int row,int col,int dir,int sum){
        if(visit[row][col]==1){
            return;
        }

        if(price[row][col][dir]>=sum){
            price[row][col][dir]=sum;
        }else{
            return;
        }

        if(row==price.length-1 && col==price.length-1){
            return;
        }

        for(int i=0;i<4;i++){
            if((dir+2)%4==i){ //180도 반대인경우(수정)
                continue;
            }
            if(row+dy[i]>=0 &&row+dy[i]<price.length && col+dx[i]>=0 && col+dx[i]<price.length){
                if(dir==i){//같은방향
                    bruteforce(row+dy[i],col+dx[i],i,sum+100);
                }else{
                    bruteforce(row+dy[i],col+dx[i],i,sum+600);
                }
            }
        }
    }
}
