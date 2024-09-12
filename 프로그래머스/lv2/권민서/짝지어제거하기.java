import java.util.*;

class Solution {

    public int solution(String s) {

        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            if (stack.isEmpty() || stack.peek() != ch[i]) {
                stack.push(ch[i]);
            } else {
                stack.pop();
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }
}
