class Solution {
    fun solution(food: IntArray): String {
        var answer = "0"
        
        for(i in food.size - 1 downTo 0){
            val cnt = food[i]
            val pairCnt = cnt / 2
            if(pairCnt == 0) continue 
            
            for(j in 0 until pairCnt){
                answer = "$i$answer$i"
            }
        }
        
        return answer
    }
}