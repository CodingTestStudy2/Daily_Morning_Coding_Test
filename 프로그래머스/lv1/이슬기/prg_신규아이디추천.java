/**
 * prg_신규아이디추천
 * 그냥 구현했음
 */
import java.util.*;

public class prg_신규아이디추천 {
    class Solution {
        public String solution(String new_id) {
            String answer = "";
            new_id = new_id.toLowerCase();
            Stack<String> stack = new Stack<>();
            
            for (int i=0; i < new_id.length(); i++) {
                char a = new_id.charAt(i);
                int c = (int)new_id.charAt(i);
                if (a == '-' || a == '_' || a == '.' || (c <= 122 && c >= 97) || (c >= 48 && c <= 57)) {
                    if (!stack.isEmpty()) {
                        String pre = stack.peek();
                        if (pre.equals(".") && pre.equals(String.valueOf(a))) continue;
                    }
                    stack.add(String.valueOf(a));
                }
            }
            if (stack.peek().equals(".")) {
                stack.pop();
            }
            
            answer = String.join("", stack);
            if (answer.equals("")) {
                answer = "a";
            }
            if (answer.charAt(0) == '.') {
                answer = answer.substring(1);
            }
            
            if (answer.length() >= 16) {
                answer = answer.substring(0, 15);
                if (answer.charAt(14) == '.') {
                    answer = answer.substring(0, 14);
                }
            }
            if (answer.length() <= 2) {
                String c = answer.substring(answer.length()-1);
                for (int i=0; i<=3-answer.length(); i++) {
                    answer += c;
                }
            }
            
            System.out.println(answer);
            
            return answer;
        }
    }
}