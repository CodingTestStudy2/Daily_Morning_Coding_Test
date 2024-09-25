import java.lang.Math.sqrt

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        val arr = Array(number + 1) { 0 }
        for (i in 1 until number + 1) {
            for (j in 1 until sqrt(i.toDouble()).toInt() + 1) {
                if (i % j == 0) {
                    if (i == j * j)
                        arr[i] += 1
                    else
                        arr[i] += 2
                }
            }
        }
        for (i in arr) {
            answer += if (i > limit)
                power
            else
                i
        }
        return answer
    }
}
