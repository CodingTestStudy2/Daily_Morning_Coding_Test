class Solution {
    fun solution(s: String): String {
        val answer = mutableListOf<String>()
        
        s.split(" ").map { word ->
            var temp = ""
            
            // 단어 내에서 인덱스 검사 
            word.forEachIndexed { idx, ch ->
                if(idx % 2 == 0){
                    temp += ch.uppercase()
                }else{
                    temp += ch.lowercase()
                }
            }
            
            answer.add(temp)
        }

        return answer.joinToString(" ")
    }
}