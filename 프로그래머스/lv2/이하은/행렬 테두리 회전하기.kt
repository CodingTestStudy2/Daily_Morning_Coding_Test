/*
R x C 2차원 배열 초기화 
쿼리 배열의 각 원소에 대해  
(x1, y1) ~ (x2, y2) 테두리 
시계 방향으로 회전 

(R+C)*2 * queries => 400 * 10000

1) row: x1, col: y2 ~ y1+1 => right, (x1, y2) 값 저장 
2) col: y1, row: x1+1 ~ x2 => up 
3) row: x2, col: y1+1 ~ y2 => left 
4) col: y2, row: x2+1 ~ x1+1 => down 
*/
import kotlin.math.*

class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = IntArray(queries.size) {0}
        val total = rows * columns
        
        val arr = Array(rows) { IntArray(columns) { 0 } }
        var cnt = 1
        for(i in 0 until rows){
            for(j in 0 until columns){
                arr[i][j] = cnt++
            }
        }
        
        for((i, q) in queries.withIndex()){
            val x1 = q[0] - 1
            val y1 = q[1] - 1
            val x2 = q[2] - 1
            val y2 = q[3] - 1
            val start = arr[x1][y2]
            var minNum = start
            
            // right 
            for(c in y2 downTo y1+1){
                arr[x1][c] = arr[x1][c-1]
                minNum = min(minNum, arr[x1][c])
            }
            
            // up 
            for(r in x1 until x2){
                arr[r][y1] = arr[r+1][y1]
                minNum = min(minNum, arr[r][y1])
            }
            
            // left 
            for(c in y1 until y2){
                arr[x2][c] = arr[x2][c+1]
                minNum = min(minNum, arr[x2][c])
            }
            
            // down
            for(r in x2 downTo x1+2){
                arr[r][y2] = arr[r-1][y2]
                minNum = min(minNum, arr[r][y2])
            }
            arr[x1+1][y2] = start
            
            answer[i] = minNum 
        }
        
        return answer
    }
}