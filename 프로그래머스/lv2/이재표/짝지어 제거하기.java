import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char alp=s.charAt(i);
            if(stack.size()==0){
                stack.push(alp);
            }else{
                char last=stack.peek();
                if(last==alp){
                    stack.pop();
                }else{
                    stack.push(alp);
                }
            }
        }
        if(stack.size()>0){
            return 0;
        }
        return 1;
    }
}
