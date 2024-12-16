import java.util.*
import kotlin.math.*

/*
aabbaccc
-> 1개 단위, 2a2ba3c

ababcdcdababcdcd 
-> 8개 단위, 2ababcdcd 

abcabcdede 
-> 3개 단위, 2abcdede 

abcabcabcabcdededededede 
-> 6개 단위, 2abcabc2dedede 

xababcdcdababcdcd -> 17
*/
class Solution {
    fun solution(s: String): Int {
        if(s.length == 1) return 1 
        var answer = s.length
    
        // 문자열 단위를 1부터 s의 절반 길이까지 늘리면서 
        for(i in 1..s.length / 2){
            var compressed = ""
            var chunk = s.substring(0, i)
            var cnt = 1
            
            // 연속된 문자열 찾기 
            // i 단위로 인덱스 증가 
            for(j in i until s.length step i){
                val nextChunk = s.substring(j, j + i) 
                
                // 같은 문자열이 연속되어 있으면 
                if(chunk == nextChunk){
                    cnt++ // 개수 갱신
                    
                    // 예외 처리 (마지막에 남은 문자열이 있는 경우) 
                    if(j + i > s.length){
                        compressed += "${if(cnt >= 2) cnt else ""}${chunk}"
                        break
                    }
                }else{
                    // 다른 문자열이 나오면 
                    // 현재까지의 압축 문자열 갱신 
                    compressed += "${if(cnt >= 2) cnt else ""}${chunk}"

                    // 예외 처리 (마지막에 남은 문자열이 있는 경우) 
                    if(j + i > s.length){
                        compressed += "${if(cnt >= 2) cnt else ""}${chunk}"
                        break
                    }
                    
                    // 다음 문자열 체크를 위해 변수 갱신
                    chunk = s.substring(j, j + i)
                    cnt = 1
                }
            }
            
            println(compressed)
            answer = min(answer, compressed.length)
        }
        
        return answer
    }
}