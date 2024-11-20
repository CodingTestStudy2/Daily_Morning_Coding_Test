class Solution {
    lateinit var board: Array<IntArray>
    val temp = mutableListOf<Int>()
    
    fun solution(arr: Array<IntArray>): IntArray {
        board = arr 
        
        divide(arr.size, 0, 0)
        
        val zero = temp.filter { it == 0 }.count()
        val one = temp.filter { it == 1 }.count()

        return intArrayOf(zero, one)
    }
    
    fun divide(n: Int, r: Int, c: Int){
        val start = board[r][c]
        
        for(i in r until r + n){
            for(j in c until c + n){
                // 4등분한 영역의 숫자가 모두 같을 때까지 분할한다.
                // 하나라도 다르면 또 다시 4등분
                if(start != board[i][j]){
                    divide(n/2, r, c)
                    divide(n/2, r+n/2, c)
                    divide(n/2, r, c+n/2)
                    divide(n/2, r+n/2, c+n/2)
                    return
                }
            }
        }
        
        // 한 영역의 숫자가 모두 같으면 시작 숫자 저장 
        temp.add(start)
    }
}
