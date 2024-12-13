typealias PII = Pair<Int, Int>

class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer = mutableListOf<PII>()
        
        hanoi(n, 1, 3, 2, answer)
        
        return Array(answer.size) { i -> 
            intArrayOf(answer[i].first, answer[i].second)
        }
    }
    
    fun hanoi(n: Int, start: Int, end: Int, mid: Int, answer: MutableList<PII>) {
        if (n == 1) {
            answer.add(start to end)
            return 
        }
        
        // 가장 큰 원판 제외한 n-1개의 원판을 가운데로 옮긴다. 
        hanoi(n - 1, start, mid, end, answer)
        
        // 가장 큰 원판을 타겟으로 옮긴다. 
        answer.add(start to end)
        
        // 가운데 있던 원판들을 타겟으로 옮긴다. 
        hanoi(n - 1, mid, end, start, answer)
    }
}