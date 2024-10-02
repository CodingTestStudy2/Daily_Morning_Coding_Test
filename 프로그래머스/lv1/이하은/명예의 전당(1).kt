import java.util.*

/**
k일 다음부터는 출연 가수의 점수가 
기존의 k번째 순위의 가수 점수보다 더 높으면
출연 가수의 점수가 명예의 전당에 오르게 되고 
기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
매일 발표된 명예의 전당의 최하위 점수를 리턴 

우선순위 큐, 최소 힙 
top < score -> top 대체 
top >= score -> score 무시 
*/
class Solution {
    fun solution(k: Int, scores: IntArray): IntArray {
        var answer = IntArray(scores.size) { 0 }
        
        val pq = PriorityQueue<Int>()
        
        scores.forEachIndexed { idx, score ->
            if(idx < k){
                pq.offer(score)
            }else{
                if(pq.peek() < score){
                    pq.poll()
                    pq.offer(score)
                }
            }
            
            answer[idx] = pq.peek()
        }
        
        return answer
    }
}