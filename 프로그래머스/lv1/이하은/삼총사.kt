/*
n <= 13 
3개의 정수를 더해서 0이 되는 경우의 수 
*/
class Solution {
    lateinit var selected: BooleanArray
    val arr = IntArray(3) {0}
    var answer = 0
    
    fun solution(number: IntArray): Int {
        selected = BooleanArray(number.size) {false}
        
        dfs(0, 0, number)
        
        return answer
    }
    
    fun dfs(idx: Int, cnt: Int, number: IntArray){
        if(cnt == 3){
            if(arr.sum() == 0) answer++
            return
        }
        
        for(i in idx until number.size){
            if(!selected[i]){
                selected[i] = true
                arr[cnt] = number[i]
                dfs(i + 1, cnt + 1, number)
                selected[i] = false
            }
        }
    }
}