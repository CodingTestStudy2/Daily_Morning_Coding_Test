import java.util.*;
class Solution {
    public int solution(int[] ingredients) {
        Stack<Integer>stack=new Stack<>();
        Queue<Integer>queue=new LinkedList<>();
        int answer = 0;
        int cnt=0;
        for(int ingredient:ingredients){
            stack.push(ingredient);
            if(stack.size()>=4){
                int s1=stack.pop();
                int s2=stack.pop();
                int s3=stack.pop();
                int s4=stack.pop();
                if(s1==1 && s2==3 && s3==2 && s4==1){
                    cnt++;
                }else{
                    stack.push(s4);
                    stack.push(s3);
                    stack.push(s2);
                    stack.push(s1);
                }
            }
        }
        return cnt;
    }
}
