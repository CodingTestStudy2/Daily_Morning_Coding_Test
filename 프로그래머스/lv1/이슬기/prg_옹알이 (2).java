/**
* 하나씩 더하면서 일치하는 발음이 있는지 확인
*/
import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        for (int i=0; i<babbling.length; i++) {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            for (int j=0; j<babbling[i].length(); j++) {
                sb.append(String.valueOf(babbling[i].charAt(j)));
                for (int k=0; k<4; k++) {
                    if (arr[k].equals(sb.toString())) {
                        if (!stack.isEmpty() && stack.peek() == k) {
                            break;
                        }
                        sb.setLength(0);
                        stack.add(k);
                    }
                }
                //System.out.println(sb.toString());
            }
            if (sb.length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}