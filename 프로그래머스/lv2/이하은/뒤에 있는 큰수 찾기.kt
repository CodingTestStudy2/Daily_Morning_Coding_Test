/*
자신보다 뒤에 있는 숫자 중에서 
자신보다 크면서 
가장 가까이 있는 수
(뒷 큰수가 없으면 -1)
N <= 100만 
*/
import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer = IntArray(numbers.size) { -1 }
        val st = ArrayDeque<Int>() 
        
        for(i in 0..numbers.lastIndex){
            // 스택의 top 원소보다 큰 수를 발견하면
            while(st.isNotEmpty() && numbers[i] > numbers[st.peek()]){
                val topIdx = st.pop()
                
                // 그 숫자가 스택의 topIdx에 대한 뒷큰수 
                answer[topIdx] = numbers[i]
            }
            
            // 스택의 top 원소보다 
            // 큰 숫자가 나올 때까지 push 
            st.push(i)
            
            //println(st.toList())
        }
        
        return answer
    }
}