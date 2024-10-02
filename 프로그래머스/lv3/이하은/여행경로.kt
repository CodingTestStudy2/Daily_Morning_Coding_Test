import java.util.*

/**
주어진 항공권을 모두 이용한 여행경로 구하기 (DFS)
ICN 노드에서 출발 (노드 최대 1만개)
가능한 경로가 2개 이상 -> 알파벳 순서가 앞서는 경로

A - B
C - D 
노드 식별자가 숫자가 아니라 문자열이다. 
*/
class Solution {
    val graph = HashMap<String, ArrayList<String>>()
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        
        // 그래프 생성
        for(ticket in tickets){
            val start = ticket[0]
            val end = ticket[1]
            graph.getOrPut(start) { arrayListOf() }.add(end)
        }
        
        // 알파벳 순서대로 경로 정렬
        for((key, value) in graph){
            value.sort()
        }
        
        // 그래프 확인
        for((start, destinations) in graph){
            println("$start -> $destinations")
        }
        
        return answer
    }
}
