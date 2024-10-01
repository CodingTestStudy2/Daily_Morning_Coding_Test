import java.util.*

class Solution {
    fun solution(names: Array<String>, yearning: IntArray, photos: Array<Array<String>>): ArrayList<Int> {
        val answer = arrayListOf<Int>()
        
        val hash = HashMap<String, Int>()
        
        for((i, name) in names.withIndex()){
            hash[name] = yearning[i]
        }
        
        for(photo in photos){
            var score = 0
            for(name in photo){
                if(hash.containsKey(name)){
                    score += hash[name] ?: 0
                }
            }
            answer.add(score)
        }

        return answer
    }
}