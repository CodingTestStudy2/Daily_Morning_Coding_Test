/*
mxn 보드에서 한칸씩 순회하며 2x2 확인
4블록이 발견되면 .으로 변경하고 개수 카운팅
밑에서 위로 올라가면서 .이 아닌 첫번째, 두번째 인덱스 찾기 -> bottom, top

// 4블록이 없어진 만큼 아래로 이동 
int gap = top - bottom - 1; 
for(r in (빈칸이 아닌 첫번째 행)..top){
    arr[r + gap][c] = arr[r][c]
    arr[r][c] = empty
}
*/
import java.util.*;
import javafx.util.Pair;

class Solution {
    char arr[][]; 
    int M, N;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n; 
        arr = new char[m + 1][n + 1]; 
        
        for(int i = 0; i < board.length; i++){
            arr[i] = board[i].toCharArray(); 
        }
        
        // 4블록 위치 저장 
        ArrayList<Pair<Integer, Integer>> temp = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(checkFourBlock(i, j)){
                    temp.add(new Pair(i, j));
                }
            }
        }
        
        int sum = 0;
        for(int i = 0; i < temp.size(); i++){
            int row = temp.get(i).getKey(); 
            int col = temp.get(i).getValue(); 
            sum += clearFourBlock(row, col);
        }
        
        //moveToBottom();
        
        return answer;
    }
    
    boolean checkFourBlock(int row, int col) {
        char start = arr[row][col];
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(row + i >= M || col + j >= N) return false;
                if(start != arr[row + i][col + j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    int clearFourBlock(int row, int col){
        int cnt = 0; 
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(arr[row + i][col + j] == '.') continue;
                else {
                    arr[row + i][col + j] = '.';
                    cnt++;
                }
            }
        }
        
        return cnt; 
    }
    
    void moveToBottom(){
        // 밑에서 위로 올라가면서 
        // .이 아닌 첫번째, 두번째 인덱스 찾기
        int bottom = -1;
        int top = -1; 
        
        for(int i = M - 1; i >= 0; i--){
            for(int j = 0; j < N; j++){
                if(arr[i][j] != '.'){
                    if(bottom == -1) bottom = i; 
                    else if(top == -1) top = i; 
                    else break; 
                }
            }
        }
        
        // int gap = top - bottom - 1;
        // for(int r = 0; r <= top; r++){
        //     arr[r + gap][c] = arr[r][c];
        //     arr[r][c] = '.'
        // }
    }
    
    void printArray(){
        for(int i = 0; i < M; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }
}