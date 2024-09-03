import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // 근데 문제는 열림 괄호가 먼저 들어가고 닫힘 괄호가 나중에 들어가야함
        Stack<Character> stk = new Stack<>();

        for (int i= 0 ; i < s.length(); i++) {
            // if ( 이면 넣기 stack에
            if (s.charAt(i) - '('== 0){
                stk.push('(');
            } else {
                if(!stk.isEmpty()){
                    stk.pop();
                }
                else {
                    return false;
                }
            }

        }
        if (!stk.isEmpty()){
            return false;
        }

        return answer;
    }
}