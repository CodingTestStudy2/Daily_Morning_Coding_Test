import java.util.Stack;

public class LC_1614 {
    class Solution {
        public int maxDepth(String s) {
            Stack<Character> stack = new Stack<>();
            int ans = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push('(');
                    ans = Math.max(ans, stack.size());
                }
                if(s.charAt(i) == ')'){
                    stack.pop();
                }
            }
            return ans;
        }
    }
}