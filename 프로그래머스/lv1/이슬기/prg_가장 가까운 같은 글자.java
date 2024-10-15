/**
* 문자열 s
HashMap 사용하기
*/
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String, Integer> s_map = new HashMap<>();
        
        for (var i=0; i<s.length(); i++) {
            if (s_map.containsKey(String.valueOf(s.charAt(i)))) {
                int value = s_map.get(String.valueOf(s.charAt(i)));
                answer[i] = i - value;
            } else {
                answer[i] = -1;
            }
            s_map.put(String.valueOf(s.charAt(i)), i);
        }
        
        return answer;
    }
}