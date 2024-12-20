import java.util.*
import kotlin.math.*

/*
압축 단위: 1..length/2 (length <= 1000)

aabbaccc (1..4)
1 a|a|b|b|a|c|c|c -> 2a2ba3c (7)
2 aa|bb|ac|cc 
3 aab|bac|cc 
4 aabb|accc

abcabcdede (1..5)
1 abcabcdede
2 ab|ca|bc|de|de -> abcabc2de (9)
3 abc|abc|ded|e -> 2abcdede (8)

1) 단위를 늘려가면서 문자열을 자른다. 
2) 연속으로 중복되는 문자열 개수를 센다. 
3) 압축 후의 문자열 길이를 구한다. 
4) 최소 길이 갱신 
*/
class Solution {
    fun solution(s: String): Int {
        var answer = s.length 
        val maxLen = s.length
        val origin = StringBuilder(s)
        val compressed = StringBuilder()
        
        for(unit in 1..maxLen/2){
            var prev = origin.substring(0, unit)
            var cnt = 1
            
            for(i in unit until maxLen step unit){
                val now = origin.substring(i, min(i + unit, maxLen))
                
                // 연속으로 중복되는 문자열 개수 카운트 
                if(prev == now){
                    cnt++
                }else{
                    if(cnt >= 2){
                        compressed.append("$cnt$prev")
                    }else{
                        compressed.append(prev)
                    }
                    
                    // 그 다음 케이스를 위한 변수 갱신
                    prev = origin.substring(i, min(i + unit, maxLen))
                    cnt = 1
                }
            }
            
            // 남은 문자열 처리 
            if(cnt >= 2){
                compressed.append("$cnt$prev")
            }else{
                compressed.append(prev)
            }

            // 최소 길이 갱신 
            answer = min(answer, compressed.length)
            compressed.setLength(0)
        }
        
        return answer 
    }
}