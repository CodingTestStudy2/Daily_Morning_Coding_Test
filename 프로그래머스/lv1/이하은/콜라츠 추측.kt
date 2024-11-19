class Solution {
    fun solution(num: Int): Int {
        var cnt = 0
        var now: Long = num.toLong()
        
        if(now == 1L) return 0
        
        while(now != 1L){
            if(cnt >= 500) return -1 
            
            if(now % 2 == 0L){
                now /= 2
            }else{
                now = now*3 + 1
            }
            
            cnt++
        }
        
        println(now)
        
        return cnt
    }
}