/*
대문자: 65~90
소문자: 97~122
*/
class Solution {
    fun solution(s: String, n: Int): String {
        val sb = StringBuilder(s)
        
        for(i in 0 until s.length){
            val ch = s[i]
            if(ch == ' ') continue
            
            var start = 0
            if(ch.isUpperCase()){
                start = 65
            }
            
            if(ch.isLowerCase()){
                start = 97
            }
            
            val next = (ch.toInt() + n - start) % 26 + start
            sb.replace(i, i + 1, next.toChar().toString())
        }
        
        return sb.toString()
    }
}