import java.util.*
typealias PII = Pair<Int, Int>
    
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q = ArrayDeque<PII>()
        for((i, priority) in priorities.withIndex()){
            q.offer(Pair(i, priority))
        }
        
        var cnt = 0
        while(!q.isEmpty()){
            val now = q.poll()
            
            // 뒤쪽에 우선순위가 더 높은 게 있다면 
            if(q.filter { now.second < it.second }.size > 0){
                // 큐에서 꺼낸 걸 뒤에 넣는다. 
                q.offer(now)
            }else{
                cnt++ // 실행한 프로세스 개수 갱신 
                if(now.first == location) break 
            }
        }
        
        return cnt 
    }
}