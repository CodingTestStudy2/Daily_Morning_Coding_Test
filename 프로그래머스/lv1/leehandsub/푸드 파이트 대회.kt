class Solution {
    fun solution(food: IntArray): String {
        var answer: String = "0"

        for (i in (food.indices).reversed()) {
            for (j in 0 until food[i] / 2) {
                answer += i.toString()
                answer = i.toString() + answer
            }
        }
        return answer
    }
}
