class Solution {
    public int solution(String[][] board, int h, int w) {
        // 정수를 저장할 변수 n
        int n = board.length;

        // 같은 색으로 색칠된 칸의 개수
        int count = 0;

        // h, w 의 변화량
        int[] dh = {0, 1, -1, 0};;
        int[] dw = {1, 0, 0, -1};

        // 반복문을 이용해 i 값을 0 ~ 3까지 반복시키며
        for( int i = 0; i <4 ; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n ){
                if (board[h][w].equals(board[h_check][w_check])){
                    count++;
                }
            }
        }

        return count;
    }
}