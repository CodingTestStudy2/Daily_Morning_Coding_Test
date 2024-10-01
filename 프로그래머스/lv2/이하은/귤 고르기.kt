import java.util.*

/**
귤은 최대 10만개 
어떻게 k개를 선정해야 귤 종류의 개수를 최소화 할까?
개수가 많은 것부터 선택하자!

2 2 3 3 5 5 / 1 4
1 1 / 1 1 2 2 2 3
2 2 3 3 / 5 5 1 4

개수가 많은 순으로 정렬 
앞에서부터 k개 선택 
집합으로 중복 제거 후 크기 리턴 (최소 종류의 수) 
*/
class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>() // 종류, 개수 
        
        for(tan in tangerine){
            hashMap.put(tan, hashMap.getOrDefault(tan, 0) + 1)
        }
        
        // 개수가 많은 순으로 정렬
        val sortedPair = hashMap.toList().sortedByDescending { it.second }
        
        val sortedList = arrayListOf<Int>()
        for((type, cnt) in sortedPair){
            for(i in 0 until cnt){
                sortedList.add(type)
            }
        }
        
        // 귤의 종류 중복 제거
        val hashSet = hashSetOf<Int>()
        
        for(i in 0 until k){
            hashSet.add(sortedList[i])
        }

        return hashSet.size
    }
}