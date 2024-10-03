import java.util.*

/*
처리 시간 = (요청부터 시작까지 대기 시간) + (작업 소요 시간) 
-> 평균 처리 시간 최소화 (소수점 이하 버림)

기본적으로 작업 요청 순서대로 처리하다가 (FCFS)
중간에 여러 작업들이 요청 들어오면 
소요 시간이 작은 것부터 우선 처리 (SJF)
*/
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val waitQ = PriorityQueue<Job>(compareBy { it.reqTime })
        val readyQ = PriorityQueue<Job>(compareBy { it.duration })
        
        // 모든 작업을 대기 큐에 삽입 
        jobs.forEach {
            waitQ.offer(Job(it[0], it[1]))
        }
        
        var turnaroundTime = 0
        var elapsedTime = 0
        
        while(waitQ.isNotEmpty() || readyQ.isNotEmpty()){
            // 현재 시간 >= 작업 요청 시간 
            // 대기 큐에 있던 작업을 레디 큐로 이동시키기 
            while(waitQ.isNotEmpty() &&
                    elapsedTime >= waitQ.peek().reqTime){
                readyQ.offer(waitQ.poll())
            }
            
            if(readyQ.isNotEmpty()){
                // 작업 소요 시간이 작은 것부터 우선 처리 
                val (reqTime, duration) = readyQ.poll()
                elapsedTime += duration
                turnaroundTime += (elapsedTime - reqTime)
            }
            // 첫번째 작업의 요청 시간이 0보다 큰 경우 
            // elapsedTime = 0 < waitQ.peek().reqTime
            else if(waitQ.isNotEmpty()){
                elapsedTime = waitQ.peek().reqTime
            }
        }
        
        return turnaroundTime / jobs.size 
    }
    
    data class Job(
        val reqTime: Int,
        val duration: Int
    )
}