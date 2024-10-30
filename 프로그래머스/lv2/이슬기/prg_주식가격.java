/**
stack에 (가격, 시간) 넣기
*/

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // (1,0) (2,1) (3,2) (2,3) (3,4)
        Stack<int[]> stack = new Stack<>();
        
        for (int p=0; p<n; p++) {
            while (!stack.isEmpty()) {
                if (stack.peek()[0] <= prices[p]) break;
                
                int[] num = stack.pop();
                answer[num[1]] = p - num[1];
            }
            stack.push(new int[]{prices[p], p});
        }
        
        int m = stack.size();
        
        for (int i=0; i<m; i++) { // 끝까지 주식 가격이 떨어지지 않은 것들
            int[] now = stack.pop();
            answer[now[1]] = n-1 - now[1];
        }
        
        return answer;
    }
}