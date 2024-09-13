class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        val apple = score.sorted().reversed()

        for (i in apple.indices) {
            if (i % m == m - 1)
                answer += (apple[i] * m)
        }

        return answer
    }
}
