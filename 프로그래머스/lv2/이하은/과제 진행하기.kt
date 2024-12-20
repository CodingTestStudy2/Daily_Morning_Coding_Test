import java.util.* 

class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer = mutableListOf<String>()
        
        // 시작 시각 빠른 순으로 정렬 
        plans.sortBy { plan -> plan[1] }
        
        // 처리해야 할 과제들을 스택에 저장 
        val works = ArrayDeque<Pair<String, Int>>()
        var currentTime = 0 
        
        for(plan in plans){
            val startTime = plan[1].toMinutes()
            
            // startTime이 될 때까지 현재 시간 증가 
            while(currentTime < startTime){
                // 수행해야 할 과제가 있으면 
                if(works.isNotEmpty()){
                    // 과제의 남은 수행 시간 감소 
                    val name = works.peek().first
                    var remainTime = works.peek().second
                    works.pop() 
                    works.push(name to --remainTime)
                    
                    // 모두 수행한 경우 정답에 저장 
                    if(remainTime == 0){
                        answer.add(name)
                        works.pop()
                    }
                }
                
                currentTime++ 
            }
            
            // 과제 수행하기 (이름, 남은 시간)
            works.push(plan[0] to plan[2].toInt())
        }
        
        // 시작이 더 빠른 과제에 밀려서 
        // 끝까지 처리 못한 과제들 완료하기 
        while(works.isNotEmpty()){
            answer.add(works.pop().first)
        }
        
        return answer.toTypedArray()
    }
    
    fun String.toMinutes(): Int {
        val times = split(":").map { it.toInt() }
        return times[0] * 60 + times[1]
    }
}