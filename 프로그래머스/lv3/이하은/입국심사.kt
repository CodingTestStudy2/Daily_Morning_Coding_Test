/*
   7 10 
0  1 2
7  3 2
10 3 4
14 5 4
20 5 6
30 end 

30 / 7 -> 4
30 / 10 -> 3
-> 총 7명 수용 가능 

   7 10 
0  1 2
7  3 2
10 3 4
14 5 4
20 5 -
21 6 - 
28 end 

28 / 7 -> 4
28 / 10 -> 2
-> 총 6명 수용 가능 

[최적화 문제]
n명을 모두 심사할 수 있으면서도 
심사 시간의 총합은 최소화 해야 한다! 

[결정 문제]
주어진 심사 시간이 x일 때,
n명 이상을 심사할 수 있는가?

최장 심사 시간: n명 모두 가장 오래 걸리는 심사관에게 심사 받는 경우
*/
import java.util.*
import kotlin.math.*

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var left: Long = 1
        var right: Long = times.maxOf{it}.toLong() * n 
        
        while(left <= right){
            var mid: Long = (left + right) / 2
            
            if(decision(n, times, mid)){
                // 최솟값 구하기
                right = mid - 1
            }else{
                // n명 모두 수용할 수 있도록 
                left = mid + 1
            }
        }
        
        return left // true 구간의 최솟값 
    }
    
    fun decision(n: Int, times: IntArray, totalTime: Long): Boolean {
        var cnt = 0L
        for(time in times){
            cnt += totalTime / time;
        }
        return cnt >= n
    }
}