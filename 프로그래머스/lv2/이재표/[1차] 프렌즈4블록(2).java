import java.util.*;
class Solution {
    char[][]boards;
    int r;
    int c;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boards=new char[m][n];
        r=m;
        c=n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                boards[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            List<int[]>list=search();
            if(list.isEmpty()){
                break;
            }
            delete(list);
            down();
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(boards[i][j]=='.'){
                    answer++;
                }
            }
        }
        // 탐색
        // 해당되는 위치 저장
        // 삭제
        // 내리기
        // 반복
        return answer;
    }
    
    private void down(){
        for (int j = 0; j < c; j++) {
            int emptyRow = r - 1;
            for (int i = r - 1; i >= 0; i--) {
                if (boards[i][j] != '.') {
                    if (i != emptyRow) {
                        boards[emptyRow][j] = boards[i][j];
                        boards[i][j] = '.';
                    }
                    emptyRow--; =
                }
            }
        }
    }
    
    private void delete(List<int[]>list){
        for (int i = 0; i < list.size(); i++) {
            int[] pos = list.get(i);
            int r = pos[0];
            int c = pos[1];
            boards[r][c] = '.';
            boards[r + 1][c] = '.';
            boards[r][c + 1] = '.';
            boards[r + 1][c + 1] = '.';
        }
    }
    private List<int[]> search(){
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                char current = boards[i][j];
                if (current == '.') {
                    continue;
                }
                if (current == boards[i][j + 1] && current == boards[i + 1][j] && current == boards[i + 1][j + 1]) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }
}
