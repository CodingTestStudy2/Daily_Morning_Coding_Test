class Solution {
    fun solution(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val N = A.size // A 행의 크기 
        val M = B[0].size // B 열의 크기 
        var answer = Array(N) { IntArray(M) { 0 } }
        
        // 행렬 곱셈의 조건
        // A 열의 크기 == B 행의 크기 
        for(i in 0 until N){
            for(j in 0 until M){
                for(k in 0 until A[0].size){
                    // A: 행 고정, 열 변화 
                    // B: 열 고정, 행 변화 
                    answer[i][j] += A[i][k] * B[k][j] 
                }
            }
        }
        
        return answer
    }
}