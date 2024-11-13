//https://school.programmers.co.kr/learn/courses/30/lessons/42584
// 런타임 에러 조심. 스택이 비어있는지 확인을 먼저할 것...

import java.util.*;
class Solution {
    public int[] solution(int[] prices) throws Exception {
        
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<prices.length; i++){
            int[] stock = {i, prices[i]}; // [시간, 가격]
            
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek()[1] > stock[1]){
                    int[] top = stack.peek();
                    answer[top[0]] = stock[0]-top[0];
                    stack.pop();
                }
            }
            
            stack.push(stock);
            
        }
        
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            answer[top[0]] = prices.length-1-top[0];
        }
        
        
        return answer;
    }
}
