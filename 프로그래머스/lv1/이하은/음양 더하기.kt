class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        
        signs.forEachIndexed { idx, positive ->
            if(!positive){
                answer += -absolutes[idx]
            }else{
                answer += absolutes[idx]
            }
        }
        
        return answer
    }
}