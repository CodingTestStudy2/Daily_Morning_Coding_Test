class Solution {
    fun solution(arr: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        
        for(cmd in commands){
            val (i, j, k) = cmd
            val temp = arr.sliceArray(i-1..j-1)
            answer.add(temp.sortedArray().get(k - 1))
        }
        
        return answer.toIntArray()
    }
}