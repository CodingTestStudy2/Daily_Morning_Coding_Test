/*
가장 많이 '함께 주문'한 단품 메뉴 -> 코스 메뉴 
최소 2가지 이상 
최소 2명 이상의 손님이 주문했던 메뉴 

orders[i] 
-> course 개수에 맞춰 코스 구성 
*/
class Solution {
    val answer = mutableListOf<String>()
    val map = sortedMapOf<String, Int>()
    var selected = BooleanArray(11) {false}
    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        
        for(order in orders){
            for(num in course){
                dfs(0, "", num, order)
                selected = BooleanArray(11) {false}
            }
        }
        
        // 가능한 코스 메뉴 중에, 개수가 가장 많은 것으로 저장
        var maxCnt = -1
        for((k, v) in map){
            if(v >= 2 && v > maxCnt){
                maxCnt = v
            }
        }

        // // value == maxCnt 문자열만 저장
        // val temp = map.asSequence().filter { it.value == maxCnt }
        // for((k, v) in temp){
        //     answer.add(k)
        // }
        
        return answer.toTypedArray()
    }
    
    fun dfs(idx: Int, now: String, total: Int, order: String){
        if(now.length == total){
            map.put(now, map.getOrDefault(now, 0) + 1)
            return
        }
        
        for(i in idx until order.length){
            if (!selected[i]){
                selected[i] = true 
                dfs(i + 1, now + order[i], total, order)
                selected[i] = false
            }
        }
    }
}