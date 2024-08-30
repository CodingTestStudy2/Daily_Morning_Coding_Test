class Solution {
    fun calcTotalDays(date: List<Int>): Int {
        return date[0] * 12 * 28 + date[1] * 28 + date[2]
    }
    
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): List<Int> {
        val answer = mutableListOf<Int>()
        
        val todayDays = calcTotalDays(
            today.split(".").map{ it.toInt() }
        )
        
        val hash = hashMapOf<String, Int>() 
        for(term in terms){
            val temp = term.split(" ")
            hash[temp[0]] = temp[1].toInt()
        }
        
        privacies.forEachIndexed { idx, privacy -> 
            val temp = privacy.split(" ")
            val collectDays = calcTotalDays(
                temp[0].split(".").map{ it.toInt() }
            )
            val termType = temp[1]
            
            // 수집 일자 + 약관의 유효 기간
            val month = hash[termType]!!
            val expireDays = collectDays + (month * 28) - 1

            // 파기할 개인정보 번호 저장
            if(todayDays > expireDays){
                answer.add(idx + 1)
            }
        }
        
        return answer
    }
}
