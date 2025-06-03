## 이진 탐색 

```kotlin
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

class Leetcode.이재훈.Solution {
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
```

## 생각의 전환 

```kotlin 
/*
h번 이상 인용된 논문이 h편 이상
-> h의 최댓값 구하기

0 1 3 5 6 | 0번 이상 인용된 논문 5편
0 1 3 5 6 | 1번 이상 인용된 논문 4편 
0 1 3 5 6 | 3번 이상 인용된 논문 3편 -> H-Index
0 1 3 5 6 | 5번 이상 인용된 논문 2편 
0 1 3 5 6 | 6번 이상 인용된 논문 1편 

val h = n - i
if(citations[i] >= h) return h
*/
class Leetcode.이재훈.Solution {
    fun solution(citations: IntArray): Int {
        val N = citations.size 
        citations.sort()
        
        for(i in citations.indices){
            val h = N - i
            if(citations[i] >= h) return h
        }
        
        return 0 
    }
}
```