class Solution {
    fun solution(new_id: String): String {
        // 1) 소문자로 치환 
        val step1 = new_id.lowercase()
        
        // 2) 알파벳 소문자, 숫자, -, _, . 제외하고는 모두 제거 
        val step2 = Regex("[^a-z0-9\\-_.]").replace(step1, "")
        
        // 3) 마침표가 2번 이상 연속 -> 하나로 대체 
        val step3 = Regex("\\.{2,}").replace(step2, ".")
        
        // 4) 마침표가 처음이나 끝에 위치하면 제거 
        val step4 = Regex("(^\\.|\\.$)").replace(step3, "")
        
        // 5) 빈 문자열이라면 a 대입
        var step5 = step4
        if(step4 == "") step5 = "a"
        
        // 6) 16자 이상이라면 첫 15개의 문자 제외하고 나머지 제거 
        val step6 = if (step5.length > 15) {
            val tmp = step5.substring(0, 15)
            // 제거하고 마지막 문자가 마침표인 경우 제거 
            if (tmp[tmp.length - 1] == '.'){
                tmp.substring(0, 14)
            } else tmp
        } else step5
        
        // 7) 길이가 2자 이하 -> 마지막 문자를 길이가 3이 될 때까지 추가 
        var step7 = step6
        if(step6.length < 3){
            val gap = 3 - step6.length
            val lastChar = step6.last()
            for(i in 0 until gap){
                step7 += lastChar
            }
        }

        return step7
    }
}