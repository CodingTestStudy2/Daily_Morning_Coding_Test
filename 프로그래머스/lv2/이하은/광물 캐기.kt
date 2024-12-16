import kotlin.math.min

class Solution {
    var answer: Int = 25 * 50 
    val hashMap = hashMapOf<String, Int>(
        "diamond" to 0,
        "iron" to 1, 
        "stone" to 2
    )
    // [곡괭이로][해당 광물을 캘 때] = 드는 피로도 
    val fatigue = listOf(
        listOf(1, 1, 1),
        listOf(5, 1, 1),
        listOf(25, 5, 1),
    ) 
    lateinit var pickCnt: MutableList<Int> // 곡괭이 개수 
    lateinit var mineralOrder: Array<String> // 캐야 하는 광물 순서 
    
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        pickCnt = picks.toMutableList()
        mineralOrder = minerals 
        
        dfs(0, 0)
        
        return answer
    }
    
    fun dfs(idx: Int, sum: Int) {
        // 광물을 모두 캤거나, 곡괭이를 모두 사용한 경우 
        if(idx == mineralOrder.size || pickCnt.all {it == 0}){
            // 최소 피로도 갱신 
            answer = min(answer, sum)
            return 
        }
        
        // 곡괭이 중에 하나 선택 
        for(i in 0..2){
            // 남은 곡괭이가 있다면 
            if(pickCnt[i] > 0) {
                pickCnt[i]--
                
                var tempIdx = idx 
                var tempSum = sum 
                
                // 곡괭이를 5번 사용했거나, 모든 광물을 캔 경우 반복X 
                while(tempIdx < idx + 5 && tempIdx < mineralOrder.size){
                    val name = mineralOrder[tempIdx]
                    tempSum += fatigue[i][hashMap[name]!!]
                    tempIdx++ 
                }
                
                dfs(tempIdx, tempSum)
                
                // 상태 복구 
                pickCnt[i]++
            }
        }
    }
}