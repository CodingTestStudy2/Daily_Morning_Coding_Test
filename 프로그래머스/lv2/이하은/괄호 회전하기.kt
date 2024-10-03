import java.util.*

/*
Deque -> pollFirst, offerLast
올바른 괄호 체크
스택에 하나씩 괄호를 넣으면서
쌍을 이루면 pop 
*/
class Solution {
    val openParens = listOf('(', '{', '[')
    val closeParens = listOf(')', '}', ']')
    
    fun solution(str: String): Int {
        var answer = 0
        val initialStr = str 
        var now = str 
        
        val dq = ArrayDeque<Char>()
        for(ch in str){
            dq.offer(ch)
        }
        
        do{
            if(isBalanced(now)) answer++
            
            val first = dq.peekFirst()
            dq.pollFirst()
            dq.offerLast(first)
            
            now = dq.joinToString("")
        }while(now != initialStr) // 원래 문자열로 돌아오면 종료 
        
        return answer
    }
    
    fun isBalanced(str: String): Boolean {
        val stack = ArrayDeque<Char>()
        
        for(ch in str){
            // 열린 괄호는 push 
            if(openParens.contains(ch)){
                stack.push(ch)
                continue
            }
            
            // 닫힌 괄호는 쌍이랑 같이 pop 
            if(!stack.isEmpty()){
                if(isCoupled(stack.peek(), ch)){
                    stack.pop()
                }else{
                    return false
                }
            }else{
                return false
            }
        }
        
        return stack.isEmpty()
    }
    
    fun isCoupled(start: Char, end: Char): Boolean {
        // 적어도 하나가 조건에 걸리면 성공 
        // 전부 통과 못하면 실패
        var flag = false
        for(i in 0..2){
            if(start == openParens[i] && end == closeParens[i]){
                flag = true
                break
            }
        }
        return flag
    }
}