import java.util.*
import kotlin.math.*
typealias PII = Pair<Int, Int>

/*
일정 금액 지불 -> 10일 동안 회원 자격 부여
회원 대상으로 매일 한 개의 제품 할인 
하루에 하나씩만 구매 가능 

자신이 원하는 제품과 수량이 
할인하는 날짜와 10일 연속으로 일치할 경우

바나나3, 사과2, 쌀2, 돼지고기2, 냄비1
치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나 

정현이가 원하는 제품을 모두 할인 받을 수 있는, 회원 등록 날짜의 총 일수
가능한 날이 없으면 0 리턴 
*/
class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val n = want.size 
        
        val wantMap = hashMapOf<String, Int>()
        for(i in 0 until n){ // 최대 10 
            wantMap[want[i]] = number[i]
        }
        
        var start = 0
        var end = 10
        while(end <= discount.size){ // 최대 10만 
            // [start, end) 구간에서 
            // 원하는 거 모두 할인하는지 확인 (수량까지)
            val discountMap = hashMapOf<String, Int>()
            for(idx in start until end){
                val name = discount[idx]
                discountMap[name] = (discountMap[name] ?: 0) + 1
            }
            
            var possible = true
            for((name, amount) in wantMap){
                if(!discountMap.containsKey(name) || 
                        discountMap.getOrDefault(name, 0) < amount
                  ) {
                    possible = false
                    break
                }
            }
            
            if(possible){
                answer++
            }
            
            start++
            end++
        }
        
        return answer
    }
}