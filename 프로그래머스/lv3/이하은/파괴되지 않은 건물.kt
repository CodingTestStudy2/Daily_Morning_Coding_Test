/*
최종적으로 내구도가 1이상이면 파괴되지 않은 건물 

type1 -> 적군: -degree
type2 -> 아군: +degree
*/
class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        val N = board.size 
        val M = board[0].size
        
        // 크기를 가로, 세로 1칸씩 크게 잡는다. 
        val arr = Array(N + 1) { IntArray(M + 1) { 0 } } 

        for(row in skill){
            val type = row[0]
            var degree = row[5]
            if(type == 1){
                degree *= -1
            }
            
            val r1 = row[1]
            val c1 = row[2]
            val r2 = row[3]
            val c2 = row[4]
            
            // 변화량 누적합 
            arr[r1][c1] += degree
            arr[r2 + 1][c2 + 1] += degree
            arr[r1][c2 + 1] += -degree
            arr[r2 + 1][c1] += -degree
        }
        
        // 위에서 아래로 누적합 
        for(i in 0..N-1){
            for(j in 0..M-1){
                arr[i + 1][j] += arr[i][j]
            }
        }

        // 왼쪽에서 오른쪽으로 누적합 
        for(i in 0..N-1){
            for(j in 0..M-1){
                arr[i][j + 1] += arr[i][j]
            }
        }
        
        // 원본 배열과 더하기 
        for(i in 0..N-1){
            for(j in 0..M-1){
                if(board[i][j] + arr[i][j] >= 1) answer++
            }
        }
        
        return answer 
    }
}