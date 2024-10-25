/*
행 개수 n <= 100만
행 위치 k < n 
cmd 개수 <= 20만 
X <= 30만

C : 마지막 행 삭제하면 cur--
Z : 위쪽에 삽입하면 cur++
가장 최근에 삭제된 것부터 복구 -> stack 
*/
import java.util.*

class Solution {
    fun solution(n: Int, k: Int, commands: Array<String>): String {
        var tableSize = n 
        var cur = k 
        val deleted = ArrayDeque<Int>()
        
        for(cmd in commands){ 
            val temp = cmd.split(" ")
            
            when(temp[0]){
                "U" -> cur -= temp[1].toInt()
                "D" -> cur += temp[1].toInt() 
                "C" -> {
                    deleted.push(cur) // cur: 7 
                    tableSize-- // 8 -> 7 
                    if(cur == tableSize) cur-- 
                }
                "Z" -> {
                    val idx = deleted.pop()
                    tableSize++ 
                    if(idx <= cur) cur++ // 등호 포함해야 함. 
                }
            }
        }
        
        val sb = StringBuilder()
        sb.append("O".repeat(tableSize))
        
        while(!deleted.isEmpty()){
            val idx = deleted.pop()
            sb.insert(idx, "X")
        }
        
        return sb.toString() 
    }
}