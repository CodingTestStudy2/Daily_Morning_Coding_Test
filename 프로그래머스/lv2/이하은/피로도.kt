import kotlin.math.*

class Solution {
    lateinit var selected: MutableList<Boolean>
    lateinit var arr: Array<IntArray>
    lateinit var temp: MutableList<Int>
    var N = 0
    var K = 0
    var answer: Int = -1
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        N = dungeons.size
        K = k 
        
        selected = MutableList(N){false}
        temp = MutableList(N){0} // 선택된 원소의 인덱스 저장 
        arr = dungeons
        
        // 던전의 최대 개수 <= 8
        // 가능한 모든 순열을 구하자. 
        perm(0)
        
        return answer
    }
    
    fun perm(cnt: Int){
        if(cnt == N){
            answer = max(answer, calcDungeons())
            return
        }
        
        for(i in 0 until N){
            if(!selected[i]){
                selected[i] = true
                temp[cnt] = i
                perm(cnt + 1)
                selected[i] = false
            }
        }
    }
    
    fun calcDungeons(): Int {
        var remained = K 
        var cnt = 0
        
        for(i in 0 until N){
            val idx = temp[i] // 선택된 던전의 인덱스
            val required = arr[idx][0] // 최소 필요량
            val consumed = arr[idx][1] // 소모량
            
            if(remained >= required){
                remained -= consumed
                cnt++
            }else{
                break
            }
        }
        
        return cnt 
    }
}