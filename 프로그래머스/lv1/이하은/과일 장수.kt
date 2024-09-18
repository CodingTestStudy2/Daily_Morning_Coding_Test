class Solution {
    fun solution(k: Int, m: Int, scores: IntArray): Int {
        var answer: Int = 0
        
        // 내림차순 정렬 (최대 100만)
        scores.sortDescending()
        
        // m = 4 | 3 3 2 2 | 1 1 1 -> 3 
        // m = 3 | 4 4 4 | 4 4 4 | 2 2 2 | 2 1 1 -> 2 5 8 11 
        var idx = m - 1
        var sum = 0
        while(idx < scores.size){
            sum += scores[idx] * m
            idx += m
        }
        
        return sum 
    }
}