/*
발표한 논문 n편 중 
h번 이상 인용된 논문이 h편 이상이고 
나머지 논문이 h번 이하 인용 
-> h의 최댓값 구하기 
-> n <= 1000, h <= 10000
-> 인용 횟수 >= h, 논문의 개수 >= h

0 1 3 5 6
left = 0, right = citations.last()
인용 횟수가 h 이상인 첫번째 위치 찾기 
그러한 논문의 개수 N - idx >= h 
*/
import kotlin.math.*
import java.util.*

class Solution {
    fun solution(citations: IntArray): Int {
        val N = citations.size 
        citations.sort()
        
        var left = 0
        var right = citations.last()
        var ans = -1 
        
        while(left <= right){
            val h = (left + right) / 2
            
            for(i in citations.indices){
                // 인용 횟수가 h 이상이 되는 첫번째 위치 찾기
                if(citations[i] >= h){
                    if(N - i >= h){
                        ans = max(ans, h)
                        left = h + 1
                    }else{
                        right = h - 1 
                    }
                    break
                }
            }
        }
        
        return ans
    }
}