/*
여러 집합을 크기 순으로 오름차순 정렬
2 21 213 2134
2 21 123 1243 -> 2134
3 23 423 2341 -> 3241

크기가 작은 것부터 확인하면서 
앞의 숫자부터 하나씩 자리 고정 
*/
class Solution {
    fun solution(s: String): IntArray {
        val numbers = mutableListOf<List<Int>>()
        val answer = mutableListOf<Int>()
        
        for(i in 1..s.length-2){
            if(s[i] == '{'){
                val closeIdx = s.indexOf('}', i + 1)
                val temp = s.substring(i + 1, closeIdx).split(',').map { it.toInt() }
                numbers.add(temp)
            }
        }
        
        numbers.sortBy { it.size }
        
        for(arr in numbers){
            for(num in arr){
                if(!answer.contains(num)){
                    answer.add(num)
                    break
                }
            }
        }
        
        return answer.toIntArray()
    }
}