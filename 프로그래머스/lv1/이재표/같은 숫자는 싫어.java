import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer>stack=new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            int peek=stack.peek();
            if(peek==arr[i]){
                continue;
            }
            stack.push(arr[i]);
        }
        int[]answer=new int[stack.size()];
        int idx=0;
        for(Integer s:stack){
            answer[idx++]=s;
        }
        return answer;
    }
}
