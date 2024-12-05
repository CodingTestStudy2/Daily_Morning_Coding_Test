/*
가장 많이 '함께 주문'한 단품 메뉴 -> 코스 메뉴 
최소 2가지 이상의 메뉴 
최소 2명 이상의 손님이 주문했던 메뉴 

XW == WX 
XXYY == XYXY 
=> 순서가 달라도 문자의 구성이 같으면, 동일하게 간주해야 함.
=> 맵에 정렬된 문자열을 키로 저장하자. 
*/
class Solution {
    val answer = mutableListOf<String>()
    val map = sortedMapOf<String, Int>() // 키에 따라 정렬된 맵 (키 자체도 정렬된 문자열) 
    var selected = BooleanArray(11) {false}
    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        for(type in course){
            // 각 손님의 단품 메뉴 주문에 대해 
            // 가능한 조합 구하기 
            for(order in orders){
                dfs(0, "", type, order)
                selected = BooleanArray(11) {false}
            }
            
            // (코스 종류, 최대 주문 수)
            var maxCnt = -1
            for((k, v) in map){
                if(v >= 2 && v > maxCnt){
                    maxCnt = v
                }
            }

            // 최대 주문 개수에 해당하는 것만 정답으로 저장 
            for((k, v) in map){
                if(v == maxCnt){
                    answer.add(k)
                }
            }
            
            map.clear()
        }
        
        return answer.sorted().toTypedArray()
    }
    
    fun dfs(idx: Int, now: String, total: Int, order: String){
        if(now.length == total){
            val temp = now.toList().sorted().joinToString("")
            map.put(temp, map.getOrDefault(temp, 0) + 1)
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