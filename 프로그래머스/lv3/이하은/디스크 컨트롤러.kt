import java.util.*

/*
처리 시간 = (요청부터 시작까지 대기 시간) + (작업 소요 시간) 
-> 평균 처리시간 최소화 (소수점 이하 버림)

작업 시간이 짧은 것부터 처리 (SJF)
작업 소요 시간 순으로 오름차순 정렬 

대기 0, 작업 3
대기 2-3, 작업 6 
대기 1-9, 작업 9 
-> 요청을 보내고 처음 시작할 때까지 걸린 시간 
*/
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var totalTime = 0
        
        // 작업 소요 시간 순으로 오름차순 정렬
        jobs.sortBy { job -> job[1] }
        
        // 총 처리 시간 계산
        for(i in jobs.indices){
            // 이전 작업들의 누적 소요 시간 
            var prevTaskTimes = 0
            for(j in 0 until i){
                prevTaskTimes += jobs[j][1]
            }
            
            totalTime += if(prevTaskTimes > 0){
                (prevTaskTimes - jobs[i][0]) + jobs[i][1]
            }else{
                jobs[i][1]
            }
        }
        
        return (totalTime / jobs.size).toInt()
    }
}