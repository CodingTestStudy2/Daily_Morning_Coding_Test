import java.util.*

/**
연속하는 부분 수열의 합으로 만들 수 있는 수가 몇개인지 
연속 부분 수열의 길이: 1 <= k <= n

1 2 3 4 5 | 1 2 3 4 5
k=1 있는 그대로 add
k=2 4가지, 11
k=3 3가지, 21 12
k=4 2가지, 31 22 13
k=5 배열 전체의 합 add 

연속 부분 수열 (슬라이딩 윈도우)
var start = 0
var end = k-1
until start == n-1
-> 합을 구해서 set에 저장 
*/
class Solution {
    fun solution(arr: IntArray): Int {
        val hashSet = HashSet<Int>()
        val n = arr.size
        
        for(k in 1..n){ // N 
            if(k == 1){
                for(e in arr) hashSet.add(e)
                continue
            }
            
            if(k == n){
                hashSet.add(arr.sum())
                continue
            }
            
            val flattenArr = arr + arr
            var start = 0
            var end = k - 1
            
            while(start < n){ // N 
                var sum = 0
                for(i in start..end){ // K (부분 수열의 길이)
                    sum += flattenArr[i]
                }
                hashSet.add(sum)
                
                start++
                end++
            }
        }
        
        return hashSet.size
    }
}