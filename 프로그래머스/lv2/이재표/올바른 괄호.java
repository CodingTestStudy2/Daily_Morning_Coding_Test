import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character>stack=new Stack<>();
        for(int idx1=0;idx1<s.length();idx1++){ //주어진 s를 돌기위한 반복문
            if(stack.size()==0){
                if(s.charAt(idx1)==')'){
                    return false;
                }
                stack.push(s.charAt(idx1));
                continue;
            }
            char peek=stack.peek();
            if(peek=='('){
                if(s.charAt(idx1)==')'){
                    stack.pop();
                }else{
                    stack.push(s.charAt(idx1));
                }
            }
        }
        if(stack.size()>0){
            return false;
        }
        return true;
    }
}
