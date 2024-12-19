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
O win: O의 개수 == X의 개수 + 1
X win: O의 개수 == X의 개수

무승부 
OOX
XOO
OXX

빙고가 없는 경우 
OOX
O.X
X..

한 사람이 두번 이상 빙고
OXO
XOX
OXO
-> possible 

OOO
XOX
XXO
-> impossible 

동시에 빙고 
OOO
XXX
...
*/
class Solution {
    lateinit var arr: Array<String>
    
    fun solution(board: Array<String>): Int {
        arr = board 
        var ocnt = 0
        var xcnt = 0
        
        for(row in board){
            for(e in row){
                if(e == 'O') ocnt++
                if(e == 'X') xcnt++
            }
        }
        
        val obingo = countBingo('O')
        val xbingo = countBingo('X')

        // 게임 순서 확인
        if(ocnt < xcnt || ocnt > xcnt + 1) return 0 
        
        // 빙고 개수 확인
        // if(obingo >= 2 || xbingo >= 2) return 0 // 이거 추가하면 오답 
        if(obingo >= 1 && xbingo >= 1) return 0 

        // 게임 승자에 따라 말의 개수 확인
        if(obingo >= 1 && ocnt != xcnt + 1) return 0
        if(xbingo >= 1 && ocnt != xcnt) return 0
        
        return 1
    }
    
    fun countBingo(turn: Char): Int {
        var bingo = 0 
        for(i in 0..2){
            bingo += checkRow(i, turn)
            bingo += checkColumn(i, turn)
        }
        bingo += checkStartLeftDiagonal(turn)
        bingo += checkStartRightDiagonal(turn)
        return bingo 
    }
    
    fun checkRow(row: Int, turn: Char): Int {
        for(i in 0..2){
            if(arr[row][i] != turn) return 0
        }
        return 1
    }
    
    fun checkColumn(col: Int, turn: Char): Int {
        for(i in 0..2){
            if(arr[i][col] != turn) return 0
        }
        return 1
    }

    fun checkStartLeftDiagonal(turn: Char): Int {
        for(i in 0..2){
            if(arr[i][i] != turn) return 0 
        }
        return 1 
    }
    
    fun checkStartRightDiagonal(turn: Char): Int {
        for(i in 0..2){
            if(arr[2-i][i] != turn) return 0 
        }
        return 1 
    }
}