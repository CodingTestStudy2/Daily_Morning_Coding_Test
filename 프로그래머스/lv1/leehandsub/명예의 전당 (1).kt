import java.util.*

class Solution {
    fun solution(k: Int, score: IntArray): List<Int> {
        val answer = mutableListOf<Int>()
        val pq = PriorityQueue<Int>()

        for (i in score) {
            if (pq.size == k) {
                if (i > pq.peek()) {
                    pq.add(i)
                    pq.poll()
                }
            } else {
                pq.add(i)
            }
            answer.add(pq.peek())
        }
        return answer
    }
}
