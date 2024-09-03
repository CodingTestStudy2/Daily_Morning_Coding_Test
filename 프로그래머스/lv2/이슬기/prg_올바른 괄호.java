/**
* 1. Stack으로 풀기
*/
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            if (s.substring(i, i+1).equals("(")) {
                stack.add(s.substring(i, i+1));
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}