import java.util.*
import kotlin.math.*

/*
(t의 부분 문자열 <= p)가 되는 횟수
t의 최대 길이 1만

Int는 최대 10자리, Long은 최대 19자리
숫자로 변환하지 말고 문자열 자체로 비교! 
*/
class Solution {
    fun solution(t: String, p: String): Int {
        val pLen = p.length
        var answer = 0
        
        for(i in 0..(t.length-pLen)){
            val temp = t.substring(i, i + pLen)
            if(temp <= p) answer++
        }
        
        return answer 
    }
}