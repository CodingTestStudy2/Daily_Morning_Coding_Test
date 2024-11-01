//https://school.programmers.co.kr/learn/courses/30/lessons/154539

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] arr = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            while(!stack.isEmpty() && stack.peek()[1] < num){
                int[] now = stack.pop();
                arr[now[0]] = num;
            }
            
            stack.push(new int[]{i, num});
        }
        
        while(!stack.isEmpty()){
            int[] now = stack.pop();
            arr[now[0]] = -1;
        }
        
        return arr;
    }
}
