import java.util.*;
class Solution {
    int n;
    public int solution(String s) {
        int answer = 0;
        n=s.length();
        for(int i=0;i<n;i++){
            if(isCorrect(s.substring(i,n)+s.substring(0,i))){
                answer++;
            }
        }
        return answer;
    }
    public boolean isCorrect(String s){
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                    continue;
                }
                return false;
            }
            char peek=stack.peek();
            if(peek=='[' &&s.charAt(i)==']'){
                stack.pop();
            }else if(peek=='{' && s.charAt(i)=='}'){
                stack.pop();
            }else if(peek=='('&&s.charAt(i)==')'){
                stack.pop();
            }else if(s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
