import kotlin.math.*
typealias PII = Pair<Int, Int>
    
class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        val rectangles = mutableListOf<PII>()
        
        for(size in sizes){
            // 작은 것이 first에 저장되도록
            if(size[0] < size[1]){
                rectangles.add(Pair(size[0], size[1]))
            }else{
                rectangles.add(Pair(size[1], size[0]))
            }
        }
        
        // 모든 명함을 포함할 수 있는 최대 길이 구하기 
        var maxW = 0
        var maxH = 0
        rectangles.forEach { pair ->
            maxW = max(maxW, pair.first)
            maxH = max(maxH, pair.second)
        }
        
        return maxW * maxH
    }
}