import java.util.*

data class Edge(
    val start: Int,
    val end: Int,
    val cost: Int
)

class Solution {
    lateinit var parent: MutableList<Int>
        
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        val edges = mutableListOf<Edge>()
        parent = MutableList(n + 1) { 0 }
        
        // 자기 자신을 부모 번호로 초기화 
        for(i in 1..n){
            parent[i] = i;
        }
        
        for(e in costs){
            edges.add(Edge(e[0], e[1], e[2]))
        }
        
        // 간선 비용이 작은 순으로 정렬 
        edges.sortBy{ edge -> edge.cost }
        
        // 사이클을 형성하지 않을 때만 MST에 포함 
        for(e in edges){
            if(findParent(e.start) != findParent(e.end)){
                unionParent(e.start, e.end)
                answer += e.cost
            }
        }
        
        return answer
    }
    
    fun findParent(x: Int): Int {
        if(x == parent[x]) return x
        parent[x] = findParent(parent[x])
        return parent[x]
    }

    fun unionParent(a: Int, b: Int){
        var a = findParent(a)
        var b = findParent(b)
        
        if(a < b) parent[b] = a
        else parent[a] = b
    }
}