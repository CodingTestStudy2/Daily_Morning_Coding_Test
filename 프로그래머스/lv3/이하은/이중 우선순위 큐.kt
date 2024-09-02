import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val pq = PriorityQueue<Int>() // 최소 힙 
        
        for(op in operations){ // 최대 100만 
            val cmd = op[0]
            val num = op.substring(2).toInt()
            if(cmd == 'I'){
                pq.add(num)
            }else{
                if(pq.isEmpty()) continue
                
                if(num == 1){
                    pq.maxOrNull()?.let{ // O(N)
                        pq.remove(it) // O(logN)
                    }
                }else{
                    pq.poll() // O(logN)
                }
            }
        }
        
        if(pq.isEmpty()){
            return intArrayOf(0, 0)
        }else{
            return intArrayOf(pq.maxOrNull()!!, pq.peek())
        }
    }
}