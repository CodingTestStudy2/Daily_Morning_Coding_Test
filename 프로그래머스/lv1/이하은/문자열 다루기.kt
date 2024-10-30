class Solution {
    fun solution(s: String) = checkLength(s) && checkAllDigit(s)
    
    fun checkLength(s: String) = s.length == 4 || s.length == 6
    
    fun checkAllDigit(s: String) = s.all { it.isDigit() }
}