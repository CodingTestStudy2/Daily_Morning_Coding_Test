class Solution {
    fun solution(s: String): String {
        return s.toList().sortedByDescending { it }.joinToString("")
    }
}