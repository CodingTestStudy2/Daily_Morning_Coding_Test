class Solution {
    fun calcTotalDays(temp: List<String>): Int {
        return temp[0].toInt() * 12 * 28 + temp[1].toInt() * 28 + temp[2].toInt()
    }
    
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): List<Int> {
        val answer = mutableListOf<Int>()
        val todayDays = calcTotalDays(today.split("."))
        
        val hash = hashMapOf<String, Int>() 
        for(term in terms){
            val temp = term.split(" ")
            val type = temp[0]
            val month = temp[1].toInt()
            hash[type] = month
        }
        
        privacies.forEachIndexed { idx, privacy -> 
            val temp = privacy.split(" ")
            val collectDays = calcTotalDays(temp[0].split("."))
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
