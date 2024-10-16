/*
진행률 100%여도 앞의 기능이 선배포 되어야 한다.

7 3 9 -> 2 1 
5 10 1 1 20 1 -> 1 3 2 
5 10 1 1 10 1 -> 1 5 

진행률 100까지 남은 일수 계산
이전보다 작은 수가 나오면 이전 수로 대체한다. 
*/
class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val days = Array(speeds.size) {0}
        
        for(i in progresses.indices){
            val gap = 100 - progresses[i]
            val speed = speeds[i]
            
            if(gap % speed != 0){
                days[i] = (gap / speed) + 1 
            }else{
                days[i] = gap / speed
            }
        }
        
        var cnt = 1
        for(i in 1..days.size - 1){
            if(days[i - 1] >= days[i]){
                days[i] = days[i - 1] // 반례 처리  
                cnt++
            }else{
                answer.add(cnt)
                cnt = 1
            }
        }
        
        if(cnt >= 1) answer.add(cnt)
        
        return answer.toIntArray()
    }
}