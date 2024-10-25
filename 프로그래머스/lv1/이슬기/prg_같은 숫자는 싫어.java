import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        // 이전에 들어갔던 숫자면 넣지 않고, 들어가지 않은 숫자만 넣기
        for (int a=0; a<arr.length; a++) {
            if (!stack.isEmpty()) {
                if (stack.peek() != arr[a]) {
                    stack.push(arr[a]);
                }
            } else {
                stack.push(arr[a]);
            }
        }
        answer = new int[stack.size()];
        
        // 정답 도출하기
        for (int i=0; i<stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}