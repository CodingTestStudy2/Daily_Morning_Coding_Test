import java.util.*;

class Solution {
    public boolean solution(String str){
        Stack<Character> stack = new Stack<>();
        boolean answer = false;
        for(char x : str.toCharArray()) {
            if(x == '(') stack.push(x);
            else {
                if(stack.isEmpty()) return answer;
                stack.pop();
            }
        }
        if(stack.isEmpty()) answer = true;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        T.solution(str);
    }

}