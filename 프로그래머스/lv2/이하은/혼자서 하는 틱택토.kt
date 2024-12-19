/*
게임 순서는 O -> X  
가로, 세로, 대각선으로 같은 표시 3개 -> 게임 종료 
9칸이 모두 차서 표시 불가능 -> 무승부 
게임의 규칙을 지켰을 때 나오는 보드판인지 리턴 

1) 게임 순서를 지켰는지 
2) 게임 종료 조건을 지켰는지 

O 
OX
OXO
OXOX
=> O의 개수 >= X의 개수 (0 이상)

O 또는 X의 개수가 3 이상이면, 승자 확인
O win: O의 개수 > X의 개수
X win: O의 개수 == X의 개수
무승부: O의 개수 > X의 개수

OOX
XOO
OXX

OOX
O.X
X..
*/
class Solution {
    fun solution(board: Array<String>): Int {
        var ocnt = 0
        var xcnt = 0
        
        for(row in board){
            for(e in row){
                if(e == 'O') ocnt++
                if(e == 'X') xcnt++
            }
        }

        // 게임 종료 조건 확인
        if(ocnt >= 3 || xcnt >= 3){
            val winner = checkWinner(board)
            when(winner){
                'O' -> return if(ocnt - xcnt == 1) 1 else 0
                'X' -> return if(ocnt == xcnt) 1 else 0
                else -> {} // 승자 판단 불가한 경우 
            }
        }
        
        // 무승부 조건 확인
        if(ocnt + xcnt == 9){
            return if(ocnt - xcnt == 1) 1 else 0 
        }
    
        // 게임 순서 확인
        return if(ocnt == xcnt || ocnt - xcnt == 1) 1 else 0 
    }
    
    fun checkWinner(board: Array<String>): Char {
        var result = '.'
        
        for(i in 0..2){
            result = checkRow(board, i)
            if(result != '.'){
                return result
            }
        }
        
        for(j in 0..2){
            result = checkColumn(board, j)
            if(result != '.'){
                return result
            }
        }
        
        result = checkCross(board)
        if(result != '.'){
            return result
        }
        
        return result
    }
    
    fun checkRow(board: Array<String>, row: Int): Char {
        val start = board[row][0]
        val blank = '.'
        
        if(start == blank) return blank
        
        if(board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return start
        }
        
        return blank
    }
    
    fun checkColumn(board: Array<String>, col: Int): Char {
        val start = board[0][col]
        val blank = '.'
        
        if(start == blank) return blank
        
        if(board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return start
        }
        
        return blank
    }
    
    fun checkCross(board: Array<String>): Char {
        val start = board[1][1]
        val blank = '.'
        
        if(start == blank) return blank
        
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return start
        }
        
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return start 
        }
        
        return blank
    }
}