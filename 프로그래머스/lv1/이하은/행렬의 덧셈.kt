class Solution {
    fun solution(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        return Array(A.size) { i -> 
            IntArray(A[0].size) { j -> 
                A[i][j] + B[i][j]
            } 
        }
    }
}