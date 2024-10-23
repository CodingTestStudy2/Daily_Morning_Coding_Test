class Solution {
    var answer = 0
    var N = 0
    var targetNumber = 0
    lateinit var arr: IntArray
    
    fun solution(numbers: IntArray, target: Int): Int {
        N = numbers.size 
        targetNumber = target 
        arr = numbers
        
        dfs(0, 0)
        
        return answer
    }
    
    fun dfs(idx: Int, result: Int){
        if(idx == N){
            if(result == targetNumber){
                answer++
            }
            return 
        }
        
        dfs(idx + 1, result + arr[idx])
        dfs(idx + 1, result - arr[idx])
    }
}