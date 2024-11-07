/*
110 문자열을 찾는다. 
발견하면 개수 갱신 & 문자열 삭제 
가장 마지막에 있는 0 뒤에 110 삽입한다. 

삭제된 문자열에 0이 없으면, 첫번째 위치에 110 삽입한다. 
110이 여러 개 있으면, 그 개수만큼 가장 마지막 0 뒤에 110 삽입한다. 

0111111010
0111 110 110
0110110111 
*/
class Solution {
    fun solution(s: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        
        for(str in s){
            val sb = StringBuilder(str)
            var cnt = 0
            
            if(sb.length < 3){
                answer.add(sb.toString())
                continue
            }
            
            for(i in 0 until sb.length){
                if(sb.length < 3) break
                if(i <= sb.length - 3 && sb.substring(i, i + 3) == "110"){
                    cnt++ 
                    sb.delete(i, i + 3) 
                }
            }
            
            println(cnt)
            val lastZeroIdx = findLastZero(sb.toString())
            var result = ""
            
            // 0이 없는 경우 
            if(lastZeroIdx == -1){
                while(cnt > 0){
                    result += "110"
                    cnt--
                }
                result += sb.toString()
                answer.add(result)
            }else{
                for(i in 0 until sb.length){
                    result += sb[i]
                    
                    if(i == lastZeroIdx){
                        while(cnt > 0){
                            result += "110"
                            cnt--
                        }
                    }
                }
                
                answer.add(result)
            }
        }
        
        return answer.toTypedArray()
    }
    
    fun findLastZero(str: String): Int {
        for(i in str.length - 1 downTo 0){
            if(str[i] == '0') return i
        }
        return -1 
    }
}