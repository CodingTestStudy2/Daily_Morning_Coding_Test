class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer = 0
        
        for(num in left..right){
            if(countDivisorOf(num) % 2 == 0) answer += num
            else answer -= num
        }
        
        return answer
    }
    
    fun countDivisorOf(n: Int): Int {
        var cnt = 0

        for(i in 1..n){
            if(i * i > n) break // 제곱근까지만 검사 

            if(i * i == n) cnt++ // n이 제곱수인 경우 
            else if(n % i == 0) cnt += 2 // 곱셈 기준으로 대칭 
        }

        return cnt 
    }
}