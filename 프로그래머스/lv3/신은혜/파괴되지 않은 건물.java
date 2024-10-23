class Solution {
    static int cnt = 0;
    public static void game(int[][] board, int[] skill){
        int type = skill[0];
        int y1 = skill[1];
        int x1 = skill[2];
        int y2 = skill[3];
        int x2 = skill[4];
        int degree = skill[5];
        
        for(int i=y1; i<=y2; i++){
            for(int j=x1; j<=x2; j++){
                int original = board[i][j];
                if(type==1) board[i][j]-=degree;
                else board[i][j]+=degree;
            }
        }
    }
    public int solution(int[][] board, int[][] skill) {
        for(int i=0; i<skill.length; i++)
            game(board,skill[i]);

        int cnt = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]>=1) cnt++;
            }
        }
        return cnt;
    }
}
