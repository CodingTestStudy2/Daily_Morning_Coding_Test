/*
N <= 100만 
기사님이 원하는 순서대로 상자를 실어야 한다. 
보조 컨테이너 벨트는 Stack 구조 

order: 4 3 1 2 5 
move:  5
save:  2 1
truck: 4 3 -> 2

order: 5 4 3 2 1
move:   
save:   
truck: 5 4 3 2 1 -> 5 
*/
import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer = 0 
        val stack = ArrayDeque<Int>()
        var now = 1
        var idx = 0 
        
        while(now <= order.size){
            var target = order[idx]
            
            // 원하는 번호의 상자를 발견할 때마다 반복 
            while(now == target || stack.peek() == target){
                if(now == target){
                    now++ // 그 다음 상자로 이동하거나 
                }else{
                    stack.pop() // 보조 컨테이너에서 꺼내기 
                }
                
                answer++
                idx++
                
                if(idx >= order.size) break 
                
                // 타겟 번호 갱신 
                target = order[idx]
            }
            
            // 현재 상자를 보조 컨테이너에 추가
            stack.push(now++)
        }
        
        return answer
    }
}