/*
P는 0을 포함하지 않는 소수 
*/
class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val nums = Integer.toString(n, k).split('0')
        
        for(e in nums){
            if(e == "") continue
            if(isPrime(e.toLong())) answer++
        }
        
        return answer
    }
    
    fun isPrime(x: Long): Boolean {
        if(x < 2) return false
        
        for(i in 2..x){
            if(i*i > x) break 
            if(x % i == 0L) return false 
        }
        
        return true 
    }
}